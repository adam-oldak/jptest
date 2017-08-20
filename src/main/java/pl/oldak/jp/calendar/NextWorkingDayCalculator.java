package pl.oldak.jp.calendar;

import java.time.LocalDate;

/**
 * Interface for next working day calculators
 */
public interface NextWorkingDayCalculator {
    /**
     * Calculate next working day, given a requested settlement date. If requestedSettlementDate is a working day
     * itself is returned.
     * @param requestedSettlementDate Requested settlement date
     * @return Next working day
     */
    LocalDate calculateNextWorkingDay(LocalDate requestedSettlementDate);
}
