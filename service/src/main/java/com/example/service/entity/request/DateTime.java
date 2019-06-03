package com.example.service.entity.request;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * title：DateTime
 * description:
 *
 * @author yumengjie
 * @date 2019/3/26 17:44
 */

public class DateTime implements Serializable {
    private static final long serialVersionUID = -7077893190426963861L;

    transient static final long DAY_MILISECONDS = 24 * 60 * 60 * 1000;

    public static final String DATE_FORMART = "yyyy-MM-dd";

    public static final String DATETIME_FORMART = "yyyy-MM-dd HH:mm:ss";

    long ms;
    Date dt;

    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMART);
        return sdf.format(date);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static DateTime Now() {
        return new DateTime(System.currentTimeMillis());
    }

    /**
     * 最小日期
     *
     * @return
     */
    public static DateTime MinValue() {
        return new DateTime(1970, 1, 1, 0, 0, 0);
    }

    public static DateTime MaxValue() {
        return new DateTime(9000, 1, 1, 0, 0, 0);
    }

    /**
     * 年月日构造
     *
     * @param year
     * @param month
     * @param day
     */
    public DateTime(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        this.dt = calendar.getTime();
        this.ms = dt.getTime();
    }

    /**
     * 年月日时构造
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     */
    public DateTime(int year, int month, int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        this.dt = calendar.getTime();
        this.ms = dt.getTime();
    }

    /**
     * 年月日时分构造
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     */
    public DateTime(int year, int month, int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        this.dt = calendar.getTime();
        this.ms = dt.getTime();
    }

    /**
     * 年月日时分秒
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this(year, month, day, hour, minute, second, 0);
    }

    /**
     * 年月日时分秒毫秒
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @param miliSecond
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second, int miliSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);
        calendar.set(Calendar.MILLISECOND, miliSecond);
        this.dt = calendar.getTime();
        this.ms = dt.getTime();
    }

    /**
     * 移动到本月最后一天
     */
    @SuppressWarnings("deprecation")
    public void setToLastday() {
        int m = this.dt.getMonth();
        int d = 28;
        switch (m + 1) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                d = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                d = 30;

            case 2:
                int year = dt.getYear();
                if (((year % 100 == 0) && (year % 400 == 0)) || ((year % 100 != 0) && (year % 4 == 0)))
                    d = 29;
                else
                    d = 28;
                break;
            default:
                d = 30;
                break;
        }

        this.dt.setDate(d);
        this.ms = dt.getTime();
    }

    /**
     * 设置为月初
     */
    @SuppressWarnings("deprecation")
    public void setToFirstday() {
        this.dt.setDate(1);
        this.ms = dt.getTime();
    }

    /**
     * 从字符串构造日期
     *
     * @param value
     * @param fmt
     * @return
     * @throws ParseException
     */
    public static DateTime parse(String value, String... fmt) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        String f = fmt == null || fmt.length == 0 ? "yyyy/MM/dd HH:mm:ss" : fmt[0];
        SimpleDateFormat format = new SimpleDateFormat(f);
        try {
            return new DateTime(format.parse(value));
        } catch (ParseException e) {
            List<Integer> values = new ArrayList<Integer>();
            boolean open = false;
            StringBuffer buf = new StringBuffer();
            for (char ch : value.toCharArray()) {
                if (ch >= '0' && ch <= '9') {
                    if (!open) {
                        open = true;
                    }

                    buf.append(ch);
                } else {
                    open = false;
                    if (buf.length() > 0) {
                        values.add(Integer.valueOf(buf.toString()));
                    }

                    buf = new StringBuffer();
                }
            }

            if (buf.length() > 0) {
                values.add(Integer.valueOf(buf.toString()));
            }

            if (values.size() <= 0) {
                return null;
            }

            Integer[] vals = values.toArray(new Integer[0]);
            if (vals.length >= 6) {
                return new DateTime(vals[0], vals[1] - 1, vals[2], vals[3], vals[4], vals[5]);
            } else if (vals.length >= 5) {
                return new DateTime(vals[0], vals[1] - 1, vals[2], vals[3], vals[4]);
            } else if (vals.length >= 4) {
                return new DateTime(vals[0], vals[1] - 1, vals[2], vals[3]);
            } else if (vals.length >= 3) {
                return new DateTime(vals[0], vals[1] - 1, vals[2]);
            }

            return null;
        }
    }

    /**
     * 从毫秒构造日期
     *
     * @param ms
     */
    public DateTime(long ms) {
        this.ms = ms;
        this.dt = new Date(ms);
    }

    /**
     * 从日期构造
     *
     * @param dt
     */
    public DateTime(Date dt) {
        this.ms = dt.getTime();
        this.dt = new Date(this.ms);
    }

    /**
     * 复制构造
     *
     * @param d
     */
    public DateTime(DateTime d) {
        this.ms = d.ms;
        this.dt = new Date(ms);
    }

    /**
     * 添加日期
     *
     * @param calendarField
     * @param d
     */
    public void add(int calendarField, int d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(calendarField, d);
        this.dt = calendar.getTime();
        this.ms = this.dt.getTime();
    }

    /**
     * 加毫秒
     *
     * @param delta
     *            增加多少毫秒
     * @return
     */
    public DateTime addMiliseconds(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.MILLISECOND, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 加秒
     *
     * @param delta
     *            增加多少秒
     * @return
     */
    public DateTime addSeconds(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.SECOND, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 加分钟
     *
     * @param delta
     *            增加多少分钟
     * @return
     */
    public DateTime addMinutes(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.MINUTE, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 加小时
     *
     * @param delta
     *            增加多少小时
     * @return
     */
    public DateTime addHours(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.HOUR, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 加天
     *
     * @param delta
     *            增加多少天
     * @return
     */
    public DateTime addDays(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.DATE, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 加周
     *
     * @param delta
     *            增加多少周
     * @return
     */
    public DateTime addWeek(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.WEEK_OF_YEAR, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 移动周至目标的周一
     *
     * @param delta
     * @return
     */
    public DateTime addFirstdayOfWeek(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.WEEK_OF_YEAR, delta);
        int weekDelta = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekDelta != 0) {
            calendar.add(Calendar.DATE, -weekDelta);
        }
        return new DateTime(calendar.getTime());
    }

    /**
     * 加月
     *
     * @param delta
     *            增加多少月
     * @return
     */
    public DateTime addMonth(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.MONTH, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 加年
     *
     * @param delta
     *            增加多少年
     * @return
     */
    public DateTime addYear(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.add(Calendar.YEAR, delta);
        return new DateTime(calendar.getTime());
    }

    /**
     * 得到一年中第几周
     *
     * @return
     */
    public int getWeekOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到周 [0-6]
     *
     * @return
     */
    public int getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 年
     *
     * @return
     */
    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(ms));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 月
     *
     * @return
     */
    public int getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.MONDAY);
    }

    /**
     * 日
     *
     * @return
     */
    public int getDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 时
     *
     * @return
     */
    public int getHours() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.HOUR);
    }

    /**
     * 分
     *
     * @return
     */
    public int getMinutes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 秒
     *
     * @return
     */
    public int getSeconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 与当前日期天数间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractDays(DateTime d) {
        long dist = new DateTime(getYear(), getMonth(), getDay()).ms
                - new DateTime(d.getYear(), d.getMonth(), d.getDay()).ms;

        return (int) (dist * 1.0 / DAY_MILISECONDS);
    }

    /**
     * 与当前日期毫秒数间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public long SubstractMiliSeconds(DateTime d) {
        return ms - d.ms;
    }

    /**
     * 与当前日期秒数间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractSeconds(DateTime d) {
        return (int) ((ms - d.ms) / 1000);
    }

    /**
     * 与当前日期分钟间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractMinutes(DateTime d) {
        return (int) ((ms - d.ms) / (1000 * 60));
    }

    /**
     * 与当前日期小时间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractHours(DateTime d) {
        return (int) ((ms - d.ms) / (1000 * 60 * 60));
    }

    /**
     * 与当前日期周间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractWeeks(DateTime d) {

        DateTime d1 = addFirstdayOfWeek(0);
        DateTime d2 = d.addFirstdayOfWeek(0);

        long dist = new DateTime(d1.getYear(), d1.getMonth(), d1.getDay()).ms
                - new DateTime(d2.getYear(), d2.getMonth(), d2.getDay()).ms;

        return (int) (dist / (7 * 24 * 60 * 60 * 1000));
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public DateTime getDatePart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return new DateTime(year, month, date, 0, 0, 0);
    }

    /**
     * 与当前日期月间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractMonths(DateTime d) {
        return (getYear() * 12 + getMonth()) - (d.getYear() * 12 + d.getMonth());
    }

    /**
     * 与当前日期年间隔
     *
     * @param d
     *            目标日期
     * @return
     */
    public int SubstractYears(DateTime d) {
        return getYear() - d.getYear();
    }

    /**
     * 比d日期大
     *
     * @param d
     *            目标日期
     * @return
     */
    public boolean before(DateTime d) {
        return ms > d.ms;
    }

    /**
     * 比d日期小
     *
     * @param d
     *            目标日期
     * @return
     */
    public boolean after(DateTime d) {
        return ms < d.ms;
    }

    /**
     * 得到日期毫秒
     *
     * @return
     */
    public long getTime() {
        return ms;
    }

    /**
     * 得到日期
     *
     * @return
     */
    public Date getDate() {
        return dt;
    }

    /**
     * 日期部分是否相等
     *
     * @param dateTime
     * @return
     */
    public boolean isDatePartEquals(DateTime dateTime) {
        DateTime d1 = this.getDatePart();
        DateTime d2 = dateTime.getDatePart();
        return d1.getTime() == d2.getTime();
    }

    /**
     * 字符串 yyyy-MM-dd HH:mm:ss
     */
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fmt.format(dt);
    }

    /**
     * 格式化
     *
     * @param format
     * @return
     */
    public String toString(String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(dt);
    }

    /**
     * hash code
     */
    public int hashCode() {
        return dt.hashCode();
    }
}
