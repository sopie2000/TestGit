package kr.co.www.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(DateUtils.class);

	/** The Constant DEFAULT_PATTERN. */
	public static final String PATTERN_DEFAULT = "yyyy-MM-dd";

	/** The Constant DEFAULT_PATTERN. */
	public static final String PATTERN_DEFAULT2 = "yyyy/MM/dd";

	/** The Constant PATTERN_SYSDATE. */
	public static final String PATTERN_SYSDATE = "yyyyMMdd";

	/** The Constant DEFAULT_PATTERN. */
	public static final String PATTERN_YYMMDD = "yy.MM.dd";

	/** The Constant PATTERN_SYSDATE. */
	public static final String PATTERN_SYSDATE_YYYY = "yyyy";

	/** The Constant PATTERN_SYSDATE. */
	public static final String PATTERN_SYSDATE_MM = "MM";

	/** The Constant PATTERN_SYSDATE. */
	public static final String PATTERN_SYSDATE_DD = "dd";

	/** The Constant PATTERN_SYSDATE. */
	public static final String PATTERN_SYSDATE_YYYYMMDDHH24MISS = "yyyyMMddhh24Miss";

	/**
	 * 현재날짜(yyyy/MM/dd)를 가져오기.
	 * 
	 * @return the today
	 */
	public static String getToday() {
		return getToday(PATTERN_DEFAULT);

	}

	/**
	 * Gets the today.
	 * 
	 * @param format
	 *            the format
	 * @return the today
	 */
	public static String getToday(String format) {
		DateTime dt = new DateTime();
		return parseStringDate(dt, format);

	}

	/**
	 * 현재날짜(yyyy/MM/dd) 기준으로 몇 일 전후 가져오기.
	 * 
	 * @param days
	 *            the days
	 * @return the before day
	 */
	public static String getDayFromToday(int days) {

		DateTime dt = new DateTime();
		Instant pInstant = dt.withFieldAdded(DurationFieldType.days(), days)
				.toInstant();
		DateTimeFormatter fmt = DateTimeFormat.forPattern(PATTERN_DEFAULT);
		return fmt.print(pInstant);

	}

	/**
	 * 현재날짜(yyyy/MM/dd) 기준으로 몇 일 전후 가져오기.
	 * 
	 * @param days
	 *            the days
	 * @return the before day
	 */
	public static String getDayFromToday(int days , String format) {

		DateTime dt = new DateTime();
		Instant pInstant = dt.withFieldAdded(DurationFieldType.days(), days)
				.toInstant();
		DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
		return fmt.print(pInstant);

	}

	/**
	 * 오늘 날짜에서 월을 계산하여 날짜를 반환하기.
	 * 
	 * @param months
	 *            the months
	 * @return the month from today
	 */
	public static String getMonthFromToday(int months) {

		DateTime dt = new DateTime();
		Instant pInstant = dt
				.withFieldAdded(DurationFieldType.months(), months).toInstant();
		DateTimeFormatter fmt = DateTimeFormat.forPattern(PATTERN_DEFAULT);
		return fmt.print(pInstant);

	}

	/**
	 * 해당년도 1월1일 가져오기.
	 * 
	 * @return the first day for this year
	 */
	public static String getFirstDayForThisYear() {

		DateTime dt = new DateTime();
		int year = dt.getYear();
		DateTime dt2 = new DateTime(year, 1, 1, 0, 0);
		return parseStringDate(dt2, PATTERN_DEFAULT) ;

	}

	/**
	 * Gets the year list.
	 * 
	 * @param period
	 *            the period
	 * @return the year list
	 */
	public static List<String> getYearList(int period) {

		List<String> yearList = new ArrayList<String>();

		DateTime dt = new DateTime();
		int year = dt.getYear();

		int start = 0;
		int end = 0;

		if (period >= 0) {
			start = year;
			end = year + period;
		} else {
			start = year + period;
			end = year;
		}

		for (; start <= end; start++) {

			yearList.add(Integer.toString(start));
			// System.out.println(start);

		}

		Collections.reverse(yearList);

		return yearList;

	}

	/**
	 * 두 날짜 차이(day) 가져오기.
	 * 
	 * @param startDate
	 *            시작일자
	 * @param endDate
	 *            종료일자
	 * @param format
	 *            날짜포멧
	 * @return the days
	 */
	public static int getDays(String startDate, String endDate, String format) {

		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
		DateTime sDate = formatter.parseDateTime(startDate);
		DateTime eDate = formatter.parseDateTime(endDate);

		return Days.daysBetween(sDate, eDate).getDays();

	}

	/**
	 * 현재 달의 첫번째 일자 가져오기.
	 * 
	 * @return string date
	 */
	public static String getFirstDayOfCurMonth() {
		return getFirstDayOfCurMonth(PATTERN_DEFAULT);
	}

	/**
	 * 현재 달의 첫번째 일자 가져오기.
	 *
	 * @param pattern the pattern
	 * @return string date
	 */
	public static String getFirstDayOfCurMonth(String pattern) {
		DateTime firstDayOfMonth = new DateTime().dayOfMonth()
				.withMinimumValue();
		return parseStringDate(firstDayOfMonth);
	}

	/**
	 * 현재 년도의 1월 1일 가져오기.
	 *
	 * @return the first day of cur year
	 */
	public static String getFirstDayOfCurYear() {
		DateTime date = new DateTime().withMonthOfYear(1).withDayOfMonth(1);
		return parseStringDate(date, PATTERN_DEFAULT);
	}
	
	/**
	 * 현재 년도의 1월 1일 가져오기.
	 *
	 * @param pattern 날짜 패턴
	 * @return the first day of cur year
	 */
	public static String getFirstDayOfCurYear(String pattern) {
		DateTime date = new DateTime().withMonthOfYear(1).withDayOfMonth(1);
		return parseStringDate(date, pattern);
	}
	
	/**
	 * String 날짜를 DateTime으로 변환.
	 *
	 * @param strDate String 날짜
	 * @return string date
	 */
	public static String getFirstDayOfMonth(String strDate) {
		return getFirstDayOfMonth(strDate, PATTERN_DEFAULT);
	}
	
	/**
	 * String 날짜를 DateTime으로 변환.
	 * 
	 * @param strDate String 날짜
	 * @param pattern 날짜 포멧
	 * 
	 * @return string date
	 */
	public static String getFirstDayOfMonth(String strDate, String pattern) {
		DateTime firstDayOfMonth = parseDateTime(strDate, pattern).dayOfMonth()
				.withMinimumValue();
		return parseStringDate(firstDayOfMonth);
	}

	/**
	 * DateTime을 String 날짜로 변환.
	 * 
	 * @param datetime DateTime
	 * 
	 * @return string date
	 */
	public static String parseStringDate(DateTime datetime) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(PATTERN_DEFAULT);
		return fmt.print(datetime);
	}
	
	/**
	 * DateTime을 String 날짜로 변환.
	 * 
	 *@param datetime DateTime
	 * @param pattern 날짜 포멧
	 * 
	 * @return string date
	 */
	public static String parseStringDate(DateTime datetime, String pattern) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		return fmt.print(datetime);
	}

	/**
	 * String 날짜를 DateTime으로 변환.
	 * 
	 * @param strDate String 날짜
	 * @param pattern 날짜 포멧
	 * 
	 * @return string date
	 */
	public static DateTime parseDateTime(String strDate, String pattern) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
		return formatter.parseDateTime(strDate);
	}
	
	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		// System.out.println(isValid("20120228", PATTERN_DEFAULT) );

		// System.out.println(getToday());
		// System.out.println(getDayFromToday(-3));

		// System.out.println(getMonthFromToday(-8));
		// System.out.println(getFirstDayForThisYear());
		// System.out.println(isValid("2012/02/29"));

		/*
		 * System.out.println(getDays("20121124", "20121125",
		 * DateUtils.PATTERN_SYSDATE));
		 */

//		System.out.println(getFirstDayOfCurMonth());
//		System.out.println(getFirstDayOfCurMonth("2012/11/28"));
		
//		System.out.println(getFirstDayOfMonth("2012/11/28"));
		
		System.out.println(getFirstDayOfCurYear());

	}
	
	

}
