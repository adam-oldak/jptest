package pl.oldak.jp.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Calculates working days based on Arabic calendar
 */
public class ArabicNextWorkingDayCalculator implements NextWorkingDayCalculator {
    /**
     * Package protected, creation only with {@link NextWorkingDayCalculatorFactory}
     */
    ArabicNextWorkingDayCalculator() {
    }

    @Override
    public LocalDate calculateNextWorkingDay(LocalDate requestedSettlementDate) {
        DayOfWeek dayOfWeek = requestedSettlementDate.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)){
            return requestedSettlementDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        }else{
            return requestedSettlementDate;
        }
    }
}
