package org.egov.calculator.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtil {
	public static Timestamp getTimeStamp(String date) {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateObj = null;
		try {

			dateObj = formatter.parse(date);

		} catch (Exception e) {

			throw new RuntimeException();

		}

		return new java.sql.Timestamp(dateObj.getTime());
	}
}
