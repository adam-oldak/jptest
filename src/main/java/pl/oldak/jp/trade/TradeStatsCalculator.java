package pl.oldak.jp.trade;

import pl.oldak.jp.calendar.NextWorkingDayCalculatorFactory;
import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.InstructionType;
import pl.oldak.jp.model.Settlement;
import pl.oldak.jp.model.TradeStats;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class TradeStatsCalculator {
    private final InstructionSettler instructionSettler = new InstructionSettler(
            new NextWorkingDayCalculatorFactory(), new InstructionTradeAmountCalculator());

    /**
     * Predicate to select outgoing instructions
     */
    private final Predicate<Instruction> selectBuyInstructions = instruction -> instruction.getType().equals(InstructionType.BUY);

    /**
     * Predicate to select incoming instructions
     */
    private final Predicate<Instruction> selectSellInstructions = instruction -> instruction.getType().equals(InstructionType.SELL);


    /**
     *
     * @param instructionsPredicate Predicate to select buy or sell instructions
     * @param instructions List of instructions
     * @return A map of total USD trade amount by day
     */
    private Map<LocalDate, BigDecimal> getAmountSettledByDate(Predicate<Instruction> instructionsPredicate,
                                                              List<Instruction> instructions) {
        return instructions.stream()
                .filter(instructionsPredicate)
                .map(instructionSettler::settleInstruction)
                .collect(groupingBy(Settlement::getActualSettlementDate,
                        reducing(BigDecimal.ZERO, Settlement::getTradeUsdAmount, BigDecimal::add)));
    }

    /**
     * @param instructionsPredicate Predicate to select buy or sell instructions
     * @param instructions List of instructions
     * @return A map of entities by maximum trade amount for a single transaction
     */
    private LinkedHashMap<BigDecimal, String> getEntityRankingByMaxAmount(Predicate<Instruction> instructionsPredicate,
                                                                          List<Instruction> instructions) {
        return instructions.stream()
                .filter(instructionsPredicate)
                .map(instructionSettler::settleInstruction)
                .collect(groupingBy(settlement -> settlement.getInstruction().getEntity(),
                        reducing(BigDecimal.ZERO,
                                Settlement::getTradeUsdAmount,
                                BinaryOperator.maxBy(Comparator.naturalOrder()))
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        toMap(Map.Entry::getValue, Map.Entry::getKey,
                                (oldVal, newVal) -> oldVal, LinkedHashMap::new));
    }


    /**
     * Calculate trade statistics for a list of instructions
     * @param instructions List of instructions
     * @return trade statistics
     */
    public TradeStats calculateTradeStats(List<Instruction> instructions) {
        Map<LocalDate, BigDecimal> outgoingTradeByDay = getAmountSettledByDate(selectBuyInstructions, instructions);
        Map<LocalDate, BigDecimal> incomingTradeByDay = getAmountSettledByDate(selectSellInstructions, instructions);

        LinkedHashMap<BigDecimal, String> entitiesByMaxOutgoingAmount = getEntityRankingByMaxAmount(selectBuyInstructions, instructions);

        LinkedHashMap<BigDecimal, String> entitiesByMaxIncomingAmount = getEntityRankingByMaxAmount(selectSellInstructions, instructions);

        return new TradeStats(outgoingTradeByDay, incomingTradeByDay, entitiesByMaxOutgoingAmount, entitiesByMaxIncomingAmount);
    }

}
