package com.nssoft.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 시간관련 처리 유틸 클래스.
 * 
 * @author YangJunHo 2013. 1. 16.
 */
public class TimeUtil {
	private static final Log logger = LogFactory.getLog(TimeUtil.class);

	public static final long MILLI_WEEK = 1000 * 60 * 60 * 24 * 7;

	/**
	 * 无论是“日期/时间”返回的时间间隔为“milliseconds”单元.
	 * 
	 * @param parmStartDate
	 * @param parmEndDate
	 * @param parmDateFormat
	 * @return end date - start date
	 * @throws ParseException
	 */
	public static long getDateInterval(String parmStartDate,
			String parmEndDate, String parmDateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(parmDateFormat);
		Date startDate = null, endDate = null;
		try {
			startDate = format.parse(parmStartDate);
			endDate = format.parse(parmEndDate);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.equals(e);
		}

		return endDate.getTime() - startDate.getTime();
	}

	/**
	 * 输入所需的格式计算所需的时间间隔的日期/时间值.
	 * 
	 * @return
	 */
	public static String simpleCalendarFormat(String parmDateFormat,
			int parmField, int parmAmount) {
		Calendar cal = Calendar.getInstance();
		// cal.setTime( new Date ( System.currentTimeMillis() ) );
		if (parmAmount != 0) {
			cal.add(parmField, parmAmount);
		}
		return new SimpleDateFormat(parmDateFormat).format(cal.getTime());
	}

	public static String simpleCalendarFormat(String parmDateFormat) {
		Calendar cal = Calendar.getInstance();
		// cal.setTime( new Date ( System.currentTimeMillis() ) );
		return new SimpleDateFormat(parmDateFormat).format(cal.getTime());
	}

	public static boolean checkDateFormat(String parmDate) {
		String pattern = "[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
		if (java.util.regex.Pattern.compile(pattern).matcher(parmDate).find() == false
				|| parmDate.length() != 8) {
			return false;
		}
		return true;
	}

	public static String getSomeDay(String date, int day) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date sDate = formatter.parse(date);

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(sDate);
		startCal.add(Calendar.DAY_OF_MONTH, day);
		String str = formatter.format(startCal.getTime());
		return str;
	}

	public static String getSomedaysAgo(int day) {
		Calendar todayCal = Calendar.getInstance();
		todayCal.setTimeInMillis(System.currentTimeMillis());
		todayCal.add(Calendar.DAY_OF_MONTH, -day);
		return new SimpleDateFormat("yyyyMMdd").format(todayCal.getTime());
	}

	public static String getSomedaysAfter(int day) {
		Calendar todayCal = Calendar.getInstance();
		todayCal.setTimeInMillis(System.currentTimeMillis());
		todayCal.add(Calendar.DAY_OF_MONTH, day);
		return new SimpleDateFormat("yyyyMMdd").format(todayCal.getTime());
	}

	public static String dateparsing(String date) {
		date = date.substring(0, 4) + "." + date.substring(4, 6) + "."
				+ date.subSequence(6, 8) + " " + date.substring(8, 10) + ":"
				+ date.substring(10, 12) + ":" + date.substring(12, 14);
		return date;
	}

	public static String timeparsing(String time) {
		time = time.substring(0, 2) + ":" + time.substring(2, 4) + ":"
				+ time.substring(4, 6);
		return time;
	}

	public static String dayparsing(String day) {
		day = day.substring(0, 4) + "年" + day.substring(4, 6) + "月"
				+ day.substring(6, 8) + "日";
		return day;
	}

	/**
	 * 응용어플리케이션에서 고유값을 사용하기 위해 시스템에서17자리의TIMESTAMP값을 구하는 기능
	 *
	 * @param
	 * @return Timestamp 값
	 * @exception MyException
	 * @see
	 */
	public static String getTimeStamp() throws Exception {

		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern,
				Locale.CHINA);
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		rtnStr = sdfCurrent.format(ts.getTime());

		return rtnStr;
	}

	/**
	 * 특정한 time 값을 받아 yyyyMMddhhmmssSSS Timestamp로 변환
	 *
	 * @param time
	 *            값
	 * @return Timestamp 값
	 * @exception MyException
	 * @see
	 */
	public static String getTokenTimeStamp(long time) throws Exception {

		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern,
				Locale.CHINA);
		Timestamp ts = new Timestamp(time);

		rtnStr = sdfCurrent.format(ts.getTime());

		return rtnStr;
	}

	/**
	 * 특정한 time 값을 받아 yyyyMMddhhmmssSSS Timestamp로 변환
	 *
	 * @param time
	 *            값
	 * @return Timestamp 값
	 * @exception MyException
	 * @see
	 */
	public static long getDateTime(String Timestamp) {

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		Date tempDate = null;
		try {
			tempDate = df.parse(Timestamp);
		} catch (ParseException e) {
			logger.error(e);
		}
		return tempDate.getTime();
	}
}
