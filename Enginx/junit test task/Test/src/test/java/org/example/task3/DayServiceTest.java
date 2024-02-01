package org.example.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DayServiceTest {

    private static DayService dayService;

    @BeforeAll
    static void setUp() {
        dayService = new DayService();
    }

    @Test
    void testIsTodayWorkingDayForSunday() {
        LocalDate nextSunday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        assertFalse(dayService.isTodayWorkingDay(nextSunday));
    }


    @Test
    void testIsTodayWorkingDayForMonday() {
        LocalDate nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        assertTrue(dayService.isTodayWorkingDay(nextMonday));
    }

    @Test
    void testIsTodayWorkingDayForTuesday() {
        LocalDate nextTuesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        assertTrue(dayService.isTodayWorkingDay(nextTuesday));
    }

    @Test
    void testIsTodayWorkingDayForWednesday() {
        LocalDate nextWednesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        assertTrue(dayService.isTodayWorkingDay(nextWednesday));
    }

    @Test
    void testIsTodayWorkingDayForThursday() {
        LocalDate nextThursday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        assertTrue(dayService.isTodayWorkingDay(nextThursday));
    }

    @Test
    void testIsTodayWorkingDayForFriday() {
        LocalDate nextFriday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        assertTrue(dayService.isTodayWorkingDay(nextFriday));
    }


    @Test
    void testIsTodayWorkingDayForSaturday() {
        LocalDate nextSaturday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        assertFalse(dayService.isTodayWorkingDay(nextSaturday));
    }

}
