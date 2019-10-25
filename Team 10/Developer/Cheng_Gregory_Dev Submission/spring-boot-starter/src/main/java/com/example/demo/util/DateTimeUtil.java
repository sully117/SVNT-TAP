package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

	public static LocalDateTime stringToLocalTime(String string) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.nnnnnn");
		return LocalDateTime.parse(string, formatter);
	}

}
