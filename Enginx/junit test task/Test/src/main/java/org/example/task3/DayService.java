package org.example.task3;

import java.time.LocalDate;

class DayService {

  boolean isTodayWorkingDay(LocalDate localDate) {
    return switch (localDate.getDayOfWeek()) {
      case SATURDAY, SUNDAY -> false;
      default -> true;
    };
  }

}
