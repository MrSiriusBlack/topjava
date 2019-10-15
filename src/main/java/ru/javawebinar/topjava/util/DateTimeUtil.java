package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static boolean isBetweenDate(LocalDate ld, LocalDate startDate, LocalDate endDate) {
        return ld.compareTo(startDate) >= 0 && ld.compareTo(endDate) <= 0;
    }

    public static boolean isBetweenDateTime(LocalDateTime ldt, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        boolean result = true;
        if (startDate != null)
            result &= ldt.toLocalDate().compareTo(startDate) >= 0;
        if (endDate != null)
            result &= ldt.toLocalDate().compareTo(endDate) <= 0;
        if (startTime != null)
            result &= ldt.toLocalTime().compareTo(startTime) >= 0;
        if (endTime != null)
            result &= ldt.toLocalTime().compareTo(endTime) <= 0;
        return result;
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}

