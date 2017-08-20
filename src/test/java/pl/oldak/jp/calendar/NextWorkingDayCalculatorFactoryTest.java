package pl.oldak.jp.calendar;

import org.junit.Test;

import java.util.Currency;

import static org.junit.Assert.assertTrue;

public class NextWorkingDayCalculatorFactoryTest {
    private NextWorkingDayCalculatorFactory factory = new NextWorkingDayCalculatorFactory();

    @Test
    public void testArabicCalendarCurrencies() throws Exception {
        assertTrue(factory.getNextWorkingDayCalculatorForCurrency(Currency.getInstance("AED")) instanceof ArabicNextWorkingDayCalculator);
        assertTrue(factory.getNextWorkingDayCalculatorForCurrency(Currency.getInstance("SAR")) instanceof ArabicNextWorkingDayCalculator);
    }

    @Test
    public void testStandardCalendarCurrencies() throws Exception {
        assertTrue(factory.getNextWorkingDayCalculatorForCurrency(Currency.getInstance("GBP")) instanceof StandardNextWorkingDayCalculator);
        assertTrue(factory.getNextWorkingDayCalculatorForCurrency(Currency.getInstance("CAD")) instanceof StandardNextWorkingDayCalculator);
        assertTrue(factory.getNextWorkingDayCalculatorForCurrency(Currency.getInstance("EUR")) instanceof StandardNextWorkingDayCalculator);
        assertTrue(factory.getNextWorkingDayCalculatorForCurrency(Currency.getInstance("PLN")) instanceof StandardNextWorkingDayCalculator);
    }
}