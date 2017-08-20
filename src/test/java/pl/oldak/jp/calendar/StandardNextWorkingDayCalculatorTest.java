package pl.oldak.jp.calendar;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StandardNextWorkingDayCalculatorTest {
    private StandardNextWorkingDayCalculator calculator = new StandardNextWorkingDayCalculator();

    @Test
    public void testMidWeek() throws Exception {
        LocalDate wednesday = LocalDate.of(2017, 8, 16);

        assertEquals(wednesday, calculator.calculateNextWorkingDay(wednesday));
    }

    @Test
    public void testWeekStart() throws Exception {
        LocalDate monday = LocalDate.of(2017, 8, 14);

        assertEquals(monday, calculator.calculateNextWorkingDay(monday));
    }

    @Test
    public void testWeekEnd() throws Exception {
        LocalDate friday = LocalDate.of(2017, 8, 18);

        assertEquals(friday, calculator.calculateNextWorkingDay(friday));
    }

    @Test
    public void testSaturday() throws Exception {
        LocalDate saturday = LocalDate.of(2017, 8, 19);
        LocalDate monday = LocalDate.of(2017, 8, 21);

        assertEquals(monday, calculator.calculateNextWorkingDay(saturday));
    }

    @Test
    public void testSunday() throws Exception {
        LocalDate sunday = LocalDate.of(2017, 8, 20);
        LocalDate monday = LocalDate.of(2017, 8, 21);

        assertEquals(monday, calculator.calculateNextWorkingDay(sunday));
    }
}