package pl.oldak.jp.trade;

import org.junit.Test;
import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.InstructionType;
import pl.oldak.jp.model.TradeStats;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class TradeStatsCalculatorTest {
    private TradeStatsCalculator statsCalculator = new TradeStatsCalculator();

    @Test
    public void testStatsCalculations() throws Exception {
        TradeStats stats = statsCalculator.calculateTradeStats(getInstructions());

        assertEquals(expectedOutgoingAmountByDay(), stats.getOutgoingAmountByDay());
        assertEquals(expectedIncomingAmountByDay(), stats.getIncomingAmountByDay());
        assertEquals(expectedEntityRankingForOutgoingAmounts(), stats.getOutgoingEntityRanking());
        assertEquals(expectedEntityRankingForIncomingAmounts(), stats.getIncomingEntityRanking());
    }



    private Map<LocalDate, BigDecimal> expectedOutgoingAmountByDay(){
        Map<LocalDate, BigDecimal> map = new HashMap<>();
        map.put(LocalDate.of(2017, 8, 1), new BigDecimal("205.00"));
        map.put(LocalDate.of(2017, 8, 2), new BigDecimal("400.00"));
        return map;
    }

    private Map<LocalDate, BigDecimal> expectedIncomingAmountByDay(){
        Map<LocalDate, BigDecimal> map = new HashMap<>();
        map.put(LocalDate.of(2017, 8, 2), new BigDecimal("70.00"));
        return map;
    }

    private LinkedHashMap<BigDecimal, String> expectedEntityRankingForOutgoingAmounts(){
        LinkedHashMap<BigDecimal, String> map = new LinkedHashMap<>();
        map.put(new BigDecimal("400.00"), "C");
        map.put(new BigDecimal("60.00"), "B");
        map.put(new BigDecimal("10.00"), "A");
        return map;
    }

    private LinkedHashMap<BigDecimal, String> expectedEntityRankingForIncomingAmounts(){
        LinkedHashMap<BigDecimal, String> map = new LinkedHashMap<>();
        map.put(new BigDecimal("60.00"), "C");
        map.put(new BigDecimal("10.00"), "A");
        return map;
    }

    private List<Instruction> getInstructions(){
        return Arrays.asList(
                new Instruction("A",
                        InstructionType.BUY,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        10,
                        new BigDecimal("2")),
                new Instruction("B",
                        InstructionType.BUY,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        20,
                        new BigDecimal("1.5")),
                new Instruction("C",
                        InstructionType.SELL,
                        new BigDecimal("1"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 2),
                        LocalDate.of(2017, 8, 2),
                        20,
                        new BigDecimal("3")),

                new Instruction("A",
                        InstructionType.BUY,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        10,
                        new BigDecimal("2")),
                new Instruction("B",
                        InstructionType.BUY,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        30,
                        new BigDecimal("2")),
                new Instruction("C",
                        InstructionType.BUY,
                        new BigDecimal("1"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        20,
                        new BigDecimal("4")),

                new Instruction("A",
                        InstructionType.SELL,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 2),
                        LocalDate.of(2017, 8, 2),
                        10,
                        new BigDecimal("2")),
                new Instruction("B",
                        InstructionType.BUY,
                        new BigDecimal("1.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        20,
                        new BigDecimal("2")),
                new Instruction("C",
                        InstructionType.BUY,
                        new BigDecimal("10"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 2),
                        LocalDate.of(2017, 8, 2),
                        20,
                        new BigDecimal("2"))
        );
    }

}