package com.restaurant.votemenu.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.lang.Nullable;

public class DateTimeUtil {
  public static boolean isTimeToReset(LocalDateTime localDateTime) {
    return localDateTime.isAfter(LocalDate.now().atStartOfDay()) &&
        localDateTime.isBefore(LocalDate.now().atStartOfDay().plusHours(11));
  }
}
