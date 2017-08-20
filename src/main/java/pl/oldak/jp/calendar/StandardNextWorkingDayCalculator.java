package pl.oldak.jp.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Calculates working days based on standard calendar
 */
public class StandardNextWorkingDayCalculator implements NextWorkingDayCalculator {
    /**
     * Package protected, creation only with {@link NextWorkingDayCalculatorFactory}
     */
    StandardNextWorkingDayCalculator() {
    }

    @Override
    public LocalDate calculateNextWorkingDay(LocalDate requestedSettlementDate) {
        DayOfWeek dayOfWeek = requestedSettlementDate.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)){
            return requestedSettlementDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }else{
            return requestedSettlementDate;
        }
    }
}
