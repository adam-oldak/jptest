package pl.oldak.jp.calendar;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ArabicNextWorkingDayCalculatorTest {
    private ArabicNextWorkingDayCalculator calculator = new ArabicNextWorkingDayCalculator();

    @Test
    public void testWeekStart() throws Exception {
        LocalDate sunday = LocalDate.of(2017, 8, 13);

        assertEquals(sunday, calculator.calculateNextWorkingDay(sunday));
    }

    @Test
    public void testWeekEnd() throws Exception {
        LocalDate thursday = LocalDate.of(2017, 8, 17);

        assertEquals(thursday, calculator.calculateNextWorkingDay(thursday));
    }

    @Test
    public void testMidWeek() throws Exception {
        LocalDate tuesday = LocalDate.of(2017, 8, 15);

        assertEquals(tuesday, calculator.calculateNextWorkingDay(tuesday));
    }

    @Test
    public void testFriday() throws Exception {
        LocalDate friday = LocalDate.of(2017, 8, 18);
        LocalDate sunday = LocalDate.of(2017, 8, 20);

        assertEquals(sunday, calculator.calculateNextWorkingDay(friday));
    }

    @Test
    public void testSaturday() throws Exception {
        LocalDate saturday = LocalDate.of(2017, 8, 19);
        LocalDate sunday = LocalDate.of(2017, 8, 20);

        assertEquals(sunday, calculator.calculateNextWorkingDay(saturday));
    }
}