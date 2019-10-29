package com.hit.cggb.awesome.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Charies Gavin
 *         https:github.com/guobinhit
 * @date 10/25/19,11:39 AM
 * @description thread safe date utils
 */
public class ThreadSafeDateUtils {

    // Time zone of china
    private static final String CHINA_TIME_ZONE = "GMT+8:00";

    /**
     * Get the specified time format
     *
     * @param dateFormat Time format string
     * @return DateFormat
     */
    public static DateFormat getPointedDateFormat(String dateFormat) {
        // Default china time zone
        return getPointedDateFormat(dateFormat, CHINA_TIME_ZONE);
    }

    /**
     * Get the specified time format
     *
     * @param dateFormat Time format string
     * @param timeZone   Time zone string
     * @return DateFormat
     */
    public static DateFormat getPointedDateFormat(String dateFormat, String timeZone) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        df.setTimeZone(TimeZone.getTimeZone(timeZone));
        return df;
    }

    /**
     * Get yyyy-MM-dd format
     *
     * @return DateFormat
     */
    public static DateFormat getDateFormat() {
        return getPointedDateFormat(DateTimeFormat.yyyyMMdd);
    }

    /**
     * Get yyyy-MM-dd HH:mm:ss format
     *
     * @return DateFormat
     */
    public static DateFormat getDateTimeFormat() {
        return getPointedDateFormat(DateTimeFormat.yyyyMMddHHmmss);
    }

    /**
     * Get yyyy-MM-dd HH:mm:ss.SSS format
     *
     * @return DateFormat
     */
    public static DateFormat getDateTimeMillisecondFormat() {
        return getPointedDateFormat(DateTimeFormat.yyyyMMddHHmmssSSS);
    }

    /**
     * Get HH:mm format
     *
     * @return DateFormat
     */
    public static DateFormat getHourMinuteFormat() {
        return getPointedDateFormat(DateTimeFormat.HHmm);
    }

    /**
     * Get MM-dd format
     *
     * @return DateFormat
     */
    public static DateFormat getMonthDayFormat() {
        return getPointedDateFormat(DateTimeFormat.MMdd);
    }

    /**
     * Converts a date type parameter to yyyy-MM-dd format string
     *
     * @param date Pending date type parameter
     * @return Format string result
     */
    public static String formatDate(Date date) {
        return getDateFormat().format(date);
    }

    /**
     * Converts a date type parameter to yyyy-MM-dd HH:mm:ss format string
     *
     * @param date Pending date type parameter
     * @return Format string result
     */
    public static String formatDateTime(Date date) {
        return getDateTimeFormat().format(date);
    }

    /**
     * Converts a date type parameter to yyyy-MM-dd HH:mm:ss.SSS format string
     *
     * @param date Pending date type parameter
     * @return Format string result
     */
    public static String formatDateTimeMillisecond(Date date) {
        return getDateTimeMillisecondFormat().format(date);
    }

    /**
     * Converts a date type parameter to HH:mm format string
     *
     * @param date Pending date type parameter
     * @return Format string result
     */
    public static String formatHourMinute(Date date) {
        return getHourMinuteFormat().format(date);
    }

    /**
     * Converts a date type parameter to MM-dd format string
     *
     * @param date Pending date type parameter
     * @return Format string result
     */
    public static String formatMonthDay(Date date) {
        return getMonthDayFormat().format(date);
    }

    /**
     * Converts a string type parameter to yyyy-MM-dd format date
     *
     * @param strDate Pending string type parameter
     * @return Format date result
     */
    public static Date parseDate(String strDate) throws ParseException {
        return getDateFormat().parse(strDate);
    }

    /**
     * Converts a date type parameter to yyyy-MM-dd format date
     *
     * @param date Pending date type parameter
     * @return Format date result
     */
    public static Date parseDate(Date date) throws ParseException {
        return getDateFormat().parse(formatDate(date));
    }

    /**
     * Converts a string type parameter to yyyy-MM-dd HH:mm:ss format date
     *
     * @param strDate Pending string type parameter
     * @return Format date result
     */
    public static Date parseDateTime(String strDate) throws ParseException {
        return getDateTimeFormat().parse(strDate);
    }

    /**
     * Converts a date type parameter to yyyy-MM-dd HH:mm:ss format date
     *
     * @param date Pending date type parameter
     * @return Format date result
     */
    public static Date parseDateTime(Date date) throws ParseException {
        return getDateTimeFormat().parse(formatDateTime(date));
    }

    /**
     * Converts a string type parameter to yyyy-MM-dd HH:mm:ss.SSS format date
     *
     * @param strDate Pending string type parameter
     * @return Format date result
     */
    public static Date parseDateTimeMillisecond(String strDate) throws ParseException {
        return getDateTimeMillisecondFormat().parse(strDate);
    }

    /**
     * Converts a date type parameter to yyyy-MM-dd HH:mm:ss.SSS format date
     *
     * @param date Pending date type parameter
     * @return Format date result
     */
    public static Date parseDateTimeMillisecond(Date date) throws ParseException {
        return getDateTimeMillisecondFormat().parse(formatDateTimeMillisecond(date));
    }

    /**
     * Converts a string type parameter to HH:mm format date
     *
     * @param strDate Pending string type parameter
     * @return Format date result
     */
    public static Date parseHourMinute(String strDate) throws ParseException {
        return getHourMinuteFormat().parse(strDate);

    }

    /**
     * Converts a date type parameter to HH:mm format date
     *
     * @param date Pending date type parameter
     * @return Format date result
     */
    public static Date parseHourMinute(Date date) throws ParseException {
        return getHourMinuteFormat().parse(formatHourMinute(date));
    }

    /**
     * Converts a string type parameter to MM-dd format date
     *
     * @param strDate Pending string type parameter
     * @return Format date result
     */
    public static Date parseMonthDay(String strDate) throws ParseException {
        return getMonthDayFormat().parse(strDate);

    }

    /**
     * Converts a date type parameter to MM-dd format date
     *
     * @param date Pending date type parameter
     * @return Format date result
     */
    public static Date parseMonthDay(Date date) throws ParseException {
        return getMonthDayFormat().parse(formatMonthDay(date));
    }

    /**
     * Get the current time (Zone 8)
     *
     * @return Beijing time
     */
    public static Date getCurrentDate() {
        return getCurrentDate(Locale.CHINA);
    }

    /**
     * Get the current time in the specified time zone
     *
     * @param aLocale Area identification, for example Locale.CHINA
     * @return Specify time zone current time
     */
    public static Date getCurrentDate(Locale aLocale) {
        Calendar calendar = Calendar.getInstance(aLocale);
        return calendar.getTime();
    }

    /**
     * Get the current time in the specified time zone
     *
     * @param timeZone Time zone string, for example GMT+8:00
     * @return Specify time zone current time
     */
    public static Date getCurrentDate(String timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        return calendar.getTime();
    }

    /**
     * Get the zero time of the specified date
     *
     * @param n Date offset, 0 for the time of the day; a positive number for the backward time; a negative number for the forward time
     * @return Specify the zero time of the date in the format yyyy-MM-dd 00:00:00
     */
    public static Date getZeroOClockOfDate(int n) throws ParseException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);
        date = calendar.getTime();
        String startDateString = formatDate(date);
        startDateString = startDateString + " 00:00:00";
        return parseDateTime(startDateString);
    }

    /**
     * Gets the offset time of the specified time
     *
     * @param date         Appointed time
     * @param calendarType Offset type
     * @param dateFormat   Time format
     * @param n            Offset days, n is positive, then moves backward, n is negative, then moves forward
     * @return Offset time
     */
    public static Date getDeviationTime(Date date, CalendarTypeEnum calendarType, String dateFormat, int n) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone(CHINA_TIME_ZONE));
            calendar.setTime(date);

            // Set offset time type
            if (CalendarTypeEnum.YEAR.equals(calendarType)) {
                calendar.add(Calendar.YEAR, n);
            } else if (CalendarTypeEnum.MONTH.equals(calendarType)) {
                calendar.add(Calendar.MONTH, n);
            } else if (CalendarTypeEnum.DATE.equals(calendarType)) {
                calendar.add(Calendar.DATE, n);
            } else if (CalendarTypeEnum.HOUR.equals(calendarType)) {
                calendar.add(Calendar.HOUR, n);
            } else if (CalendarTypeEnum.MINUTE.equals(calendarType)) {
                calendar.add(Calendar.MINUTE, n);
            } else if (CalendarTypeEnum.SECOND.equals(calendarType)) {
                calendar.add(Calendar.SECOND, n);
            } else if (CalendarTypeEnum.MILLISECOND.equals(calendarType)) {
                calendar.add(Calendar.MILLISECOND, n);
            } else {
                throw new IllegalArgumentException("meet unknown calendar type enum : " + calendarType);
            }

            // Get offset time
            date = calendar.getTime();

            // Get the specified time format
            DateFormat pointedDateFormat = getPointedDateFormat(dateFormat);
            String migrationDateStr = pointedDateFormat.format(date);

            return pointedDateFormat.parse(migrationDateStr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Static date time format class
     */
    public static class DateTimeFormat {

        // Privatization of constructors to prevent instantiation
        private DateTimeFormat() {
        }

        // Time format string
        public static final String yyyyMMdd = "yyyy-MM-dd";
        public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
        public static final String yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
        public static final String HHmm = "HH:mm";
        public static final String MMdd = "MM-dd";
    }

    /**
     * Date time type enumeration
     */
    public enum CalendarTypeEnum {
        YEAR("year", 1),
        MONTH("month", 2),
        DATE("day", 5),
        HOUR("hour", 10),
        MINUTE("minute", 12),
        SECOND("second", 13),
        MILLISECOND("millisecond", 14);

        CalendarTypeEnum(String desc, int value) {
            this.desc = desc;
            this.value = value;
        }

        private String desc;
        private int value;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
