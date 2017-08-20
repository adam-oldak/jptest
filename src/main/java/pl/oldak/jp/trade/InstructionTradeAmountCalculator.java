package pl.oldak.jp.trade;

import pl.oldak.jp.model.Instruction;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Trade amount calculation logic
 */
public class InstructionTradeAmountCalculator {
    /**
     * Calculates trade amount in USD for a give instruction. Returned value is limited to 2 decimal points.
     * @param instruction An instruction
     * @return trade amount is USD = Price per unit * Units * Agreed Fx
     */
    public BigDecimal calculateTradeAmountInUsd(Instruction instruction) {
        return instruction.getAgreedFx().multiply(instruction.getPricePerUnit()).multiply(new BigDecimal(instruction.getUnits())).setScale(2, RoundingMode.HALF_EVEN);
    }
}
