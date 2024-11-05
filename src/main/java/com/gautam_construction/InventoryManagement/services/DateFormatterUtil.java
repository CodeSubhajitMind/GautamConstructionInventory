package com.gautam_construction.InventoryManagement.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String format(LocalDate date) {
        return date != null ? date.format(FORMATTER) : "";
    }
}
