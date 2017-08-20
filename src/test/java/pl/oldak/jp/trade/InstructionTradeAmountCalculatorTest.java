package pl.oldak.jp.trade;

import org.junit.Test;
import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.InstructionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import static org.junit.Assert.assertEquals;

public class InstructionTradeAmountCalculatorTest {
    InstructionTradeAmountCalculator calculator = new InstructionTradeAmountCalculator();

    @Test
    public void testZeroFactors() throws Exception {
        BigDecimal zero = BigDecimal.ZERO.setScale(2);
        assertEquals(zero, calculator.calculateTradeAmountInUsd(createInstruction(0, new BigDecimal("10"), new BigDecimal("10"))));
        assertEquals(zero, calculator.calculateTradeAmountInUsd(createInstruction(10, BigDecimal.ZERO, new BigDecimal("10"))));
        assertEquals(zero, calculator.calculateTradeAmountInUsd(createInstruction(10, new BigDecimal("10"), BigDecimal.ZERO)));
    }

    @Test
    public void testMountCalculation() throws Exception {
        BigDecimal result = calculator.calculateTradeAmountInUsd(createInstruction(10, new BigDecimal("1.234"), new BigDecimal("100.526")));

        assertEquals(2, result.scale());
        assertEquals(new BigDecimal("1240.49"), result);

    }

    private Instruction createInstruction(Integer units, BigDecimal agreedFx, BigDecimal pricePerUnit) {
        return new Instruction("An entity", InstructionType.BUY, agreedFx,
                Currency.getInstance("PLN"), LocalDate.now(), LocalDate.now(), units, pricePerUnit);
    }
}