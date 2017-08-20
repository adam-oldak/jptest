package pl.oldak.jp.trade;

import org.junit.Before;
import org.junit.Test;
import pl.oldak.jp.calendar.NextWorkingDayCalculator;
import pl.oldak.jp.calendar.NextWorkingDayCalculatorFactory;
import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.Settlement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class InstructionSettlerTest {
    private InstructionSettler instructionSettler;

    private NextWorkingDayCalculatorFactory nextWorkingDayCalculatorFactory;
    private NextWorkingDayCalculator nextWorkingDayCalculator;
    private InstructionTradeAmountCalculator tradeAmountCalculator;

    @Before
    public void setUp() throws Exception {
        nextWorkingDayCalculator = mock(NextWorkingDayCalculator.class);

        nextWorkingDayCalculatorFactory = mock(NextWorkingDayCalculatorFactory.class);
        when(nextWorkingDayCalculatorFactory.getNextWorkingDayCalculatorForCurrency(any(Currency.class)))
                .thenReturn(nextWorkingDayCalculator);

        tradeAmountCalculator = mock(InstructionTradeAmountCalculator.class);

        instructionSettler = new InstructionSettler(nextWorkingDayCalculatorFactory, tradeAmountCalculator);
    }

    @Test
    public void testInstructionSettlement() throws Exception {
        LocalDate requestedSettlementDate = LocalDate.now();
        LocalDate actualSettlementDate = LocalDate.now().plusDays(1);
        BigDecimal tradeAmountInUsd = mock(BigDecimal.class);

        Instruction instruction = mock(Instruction.class);
        when(instruction.getSettlementDate()).thenReturn(requestedSettlementDate);

        when(nextWorkingDayCalculator.calculateNextWorkingDay(requestedSettlementDate)).thenReturn(actualSettlementDate);
        when(tradeAmountCalculator.calculateTradeAmountInUsd(instruction)).thenReturn(tradeAmountInUsd);

        Settlement settlement = instructionSettler.settleInstruction(instruction);

        assertEquals(actualSettlementDate, settlement.getActualSettlementDate());
        assertEquals(instruction, settlement.getInstruction());
        assertEquals(tradeAmountInUsd, settlement.getTradeUsdAmount());
    }
}