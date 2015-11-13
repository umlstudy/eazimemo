package asia.sejong.web.eazimemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static final Date getDate(String format, String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static final String getString(String format, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static Date recreateDateWithDetailTime(Date date, int h24, int m, int s) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, h24);
		cal.set(Calendar.MINUTE, m);
		cal.set(Calendar.SECOND, s);
		
		return cal.getTime();
	}
}
