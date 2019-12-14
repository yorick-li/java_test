package com.yorick.pro.java_test.java_base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * 日期辅助类
 *
 * @author yorick
 */
public class DateUtils {

    /**
     * 若 less 早于 date, 返回 ===> true
     * 若 less 晚于 date, 返回 ===> false
     *
     * @param less
     * @param date
     * @return
     */
    public static boolean before(Date less, Date date) {
        LocalDate localDate1 = date2LocalDate(less);
        if (Objects.isNull(localDate1)) {
            return Boolean.FALSE;
        }
        LocalDate localDate2 = date2LocalDate(date);
        if (Objects.isNull(localDate2)) {
            return Boolean.FALSE;
        }
        return localDate1.isBefore(localDate2);
    }


    /**
     * 若 date 早于 more, 返回 ===> false
     * 若 date 晚于 more, 返回 ===> true
     *
     * @param date
     * @param more
     * @return
     */
    public static boolean after(Date date, Date more) {
        LocalDate localDate1 = date2LocalDate(date);
        if (Objects.isNull(localDate1)) {
            return Boolean.FALSE;
        }
        LocalDate localDate2 = date2LocalDate(more);
        if (Objects.isNull(localDate2)) {
            return Boolean.FALSE;
        }
        return localDate1.isAfter(localDate2);
    }


    /**
     * 若 less 早于或等于 date，返回 ===> true
     * 若 less 晚于 date，返回 ===> false
     *
     * @param less
     * @param date
     * @return
     */
    public static boolean beforeOrEqual(Date less, Date date) {
        LocalDate localDate1 = date2LocalDate(less);
        if (Objects.isNull(localDate1)) {
            return Boolean.FALSE;
        }
        LocalDate localDate2 = date2LocalDate(date);
        if (Objects.isNull(localDate2)) {
            return Boolean.FALSE;
        }
        return localDate1.isBefore(localDate2) || localDate1.isEqual(localDate2);
    }


    /**
     * 若 date 早于 more，返回 ===> false
     * 若 date 晚于或等于 more，返回 ===> true
     *
     * @param date
     * @param more
     * @return
     */
    public static boolean afterOrEqual(Date date, Date more) {
        LocalDate localDate1 = date2LocalDate(date);
        if (Objects.isNull(localDate1)) {
            return Boolean.FALSE;
        }
        LocalDate localDate2 = date2LocalDate(more);
        if (Objects.isNull(localDate2)) {
            return Boolean.TRUE;
        }
        return localDate1.isAfter(localDate2) || localDate1.isEqual(localDate2);
    }


    /**
     * 将 Date 格式化 String（格式化模式：pattern）
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate2String(Date date, String pattern) {
        if (Objects.isNull(date)) {
            System.out.println("===========>将 Date 格式化 String, date 参数为空");
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


    /**
     * 将 String 解析为 Date（格式化模式：pattern）
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date parseString2Date(String date, String pattern) throws ParseException {
        if (date == null || "".equals(date)) {
            System.out.println("===========>将 String 解析为 Date, date 的 String 参数为空");
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(date);
    }


    /**
     * 返回一个 date 时间 加 days 天的日期
     * 示例：当前时间为：2019-12-02
     *      若 days 为 +3, 返回的时间为: 2019-12-05
     *      若 days 为 -3, 返回的时间为: 2019-11-29
     *
     * @param date 某个日期或某个时间点
     * @param days (正数、负数都可以)
     * @return
     */
    public static LocalDate plusDays(Date date, int days) {
        LocalDate localDate = date2LocalDate(date);
        LocalDate plusDate = localDate.plusDays(days);
        return plusDate;
    }

    /**
     * 判断传入的日期是否在当前日期之后
     * @param date
     * @return
     */
    public static boolean isAfterNow(Date date) {
        Date now = new Date();
        return isAfter(now, date);
    }

    /**
     * 判断 date1 是否大于等于 date2
     * date1 > date2，返回 true
     * date1 <= date2，返回 false
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isAfter(Date date1, Date date2) {
        return date2.after(date1);
    }


    /**
     * 将 date 转成：LocalDate
     * @param date
     * @return
     */
    private static LocalDate date2LocalDate(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 5);
        Date time = c.getTime();
        System.out.println(formatDate2String(time, "yyyy-MM-dd HH:mm:ss"));

        // time是否大于当前日期
        System.out.println(isAfterNow(time));

    }

}
