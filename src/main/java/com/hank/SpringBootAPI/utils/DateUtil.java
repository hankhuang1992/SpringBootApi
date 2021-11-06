package com.hank.SpringBootAPI.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getNowDateStr(String format) {
		Date current = new Date();
		String dateStr = "";
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat(format);
			dateStr = sdFormat.format(current);
		} catch (Exception e) {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
			dateStr = sdFormat.format(current);
		}

		return dateStr;
	}
}
