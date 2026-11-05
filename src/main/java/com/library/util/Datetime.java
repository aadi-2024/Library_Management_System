package com.library.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datetime {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime addDays(int days) {
        return LocalDateTime.now().plusDays(days);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
}
