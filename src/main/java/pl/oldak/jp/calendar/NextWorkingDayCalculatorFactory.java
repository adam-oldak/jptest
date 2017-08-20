package pl.oldak.jp.calendar;

import java.util.Currency;

/**
 * A factory for working day calculators
 *
 */
public class NextWorkingDayCalculatorFactory {
    /**
     * Creates a {@link NextWorkingDayCalculator} for a given currency
     * @param currency A currency
     * @return Next working day calculator
     */
    public NextWorkingDayCalculator getNextWorkingDayCalculatorForCurrency(Currency currency) {
        if (currency.equals(Currency.getInstance("AED")) ||
                currency.equals(Currency.getInstance("SAR"))) {
            return new ArabicNextWorkingDayCalculator();
        } else {
            return new StandardNextWorkingDayCalculator();
        }
    }
}
