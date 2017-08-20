package pl.oldak.jp.trade;

import pl.oldak.jp.calendar.NextWorkingDayCalculator;
import pl.oldak.jp.calendar.NextWorkingDayCalculatorFactory;
import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.Settlement;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Creates settlements from instructions. Calculates actual settlement date and usd trade amount.
 */
public class InstructionSettler {
    private final NextWorkingDayCalculatorFactory nextWorkingDayCalculatorFactory;
    private final InstructionTradeAmountCalculator amountCalculator;

    public InstructionSettler(NextWorkingDayCalculatorFactory nextWorkingDayCalculatorFactory,
                              InstructionTradeAmountCalculator amountCalculator) {
        this.nextWorkingDayCalculatorFactory = nextWorkingDayCalculatorFactory;
        this.amountCalculator = amountCalculator;
    }

    /**
     * Creates a settlement from an instruction.
     * @param instruction An instruction
     * @return A settlement
     */
    public Settlement settleInstruction(Instruction instruction) {
        NextWorkingDayCalculator nextWorkingDayCalculator = nextWorkingDayCalculatorFactory.getNextWorkingDayCalculatorForCurrency(instruction.getCurrency());
        LocalDate actualSettlementDate = nextWorkingDayCalculator.calculateNextWorkingDay(instruction.getSettlementDate());
        BigDecimal amountInUsd = amountCalculator.calculateTradeAmountInUsd(instruction);

        return new Settlement(instruction, actualSettlementDate, amountInUsd);
    }
}
