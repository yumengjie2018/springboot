//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.service.excel;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTime implements Serializable {
    private static final long serialVersionUID = -7077893190426963861L;
    static final transient long DAY_MILISECONDS = 86400000L;
    public static final String DATE_FORMART = "yyyy-MM-dd";
    public static final String DATETIME_FORMART = "yyyy-MM-dd HH:mm:ss";
    long ms;
    Date dt;

    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static DateTime Now() {
        return new DateTime(System.currentTimeMillis());
    }

    public static DateTime MinValue() {
        return new DateTime(1970, 1, 1, 0, 0, 0);
    }

    public static DateTime MaxValue() {
        return new DateTime(9000, 1, 1, 0, 0, 0);
    }

    public DateTime(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(14, 0);
        this.dt = calendar.getTime();
        this.ms = this.dt.getTime();
    }

    public DateTime(int year, int month, int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, 0, 0);
        calendar.set(14, 0);
        this.dt = calendar.getTime();
        this.ms = this.dt.getTime();
    }

    public DateTime(int year, int month, int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, 0);
        calendar.set(14, 0);
        this.dt = calendar.getTime();
        this.ms = this.dt.getTime();
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this(year, month, day, hour, minute, second, 0);
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second, int miliSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);
        calendar.set(14, miliSecond);
        this.dt = calendar.getTime();
        this.ms = this.dt.getTime();
    }

    public void setToLastday() {
        this.setToFirstday();
        DateTime dt = this.addMonth(1);
        dt = dt.addDays(-1);
        this.dt = dt.getDate();
        this.ms = dt.getTime();
    }

    public void setToFirstday() {
        this.dt.setDate(1);
        this.ms = this.dt.getTime();
    }

    public static DateTime parse(String value, String... fmt) {
        if (value != null && !value.isEmpty()) {
            String f = fmt != null && fmt.length != 0 ? fmt[0] : "yyyy/MM/dd HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(f);

            try {
                return new DateTime(format.parse(value));
            } catch (ParseException var12) {
                List<Integer> values = new ArrayList();
                boolean open = false;
                StringBuffer buf = new StringBuffer();
                char[] var8 = value.toCharArray();
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    char ch = var8[var10];
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
                } else {
                    Integer[] vals = (Integer[])values.toArray(new Integer[0]);
                    if (vals.length >= 6) {
                        return new DateTime(vals[0], vals[1] - 1, vals[2], vals[3], vals[4], vals[5]);
                    } else if (vals.length >= 5) {
                        return new DateTime(vals[0], vals[1] - 1, vals[2], vals[3], vals[4]);
                    } else if (vals.length >= 4) {
                        return new DateTime(vals[0], vals[1] - 1, vals[2], vals[3]);
                    } else if (vals.length >= 3) {
                        return new DateTime(vals[0], vals[1] - 1, vals[2]);
                    } else {
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
    }

    public DateTime(long ms) {
        this.ms = ms;
        this.dt = new Date(ms);
    }

    public DateTime(Date dt) {
        this.ms = dt.getTime();
        this.dt = new Date(this.ms);
    }

    public DateTime(DateTime d) {
        this.ms = d.ms;
        this.dt = new Date(this.ms);
    }

    public void add(int calendarField, int d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(calendarField, d);
        this.dt = calendar.getTime();
        this.ms = this.dt.getTime();
    }

    public DateTime addMiliseconds(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(14, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addSeconds(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(13, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addMinutes(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(12, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addHours(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(10, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addDays(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(5, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addWeek(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(3, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addFirstdayOfWeek(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(3, delta);
        int weekDelta = calendar.get(7) - 1;
        if (weekDelta != 0) {
            calendar.add(5, -weekDelta);
        }

        return new DateTime(calendar.getTime());
    }

    public DateTime addMonth(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(2, delta);
        return new DateTime(calendar.getTime());
    }

    public DateTime addYear(int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        calendar.add(1, delta);
        return new DateTime(calendar.getTime());
    }

    public int getWeekOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(3);
    }

    public int getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(7);
    }

    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.ms));
        return calendar.get(1);
    }

    public int getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(2);
    }

    public int getDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(5);
    }

    public int getHours() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(10);
    }

    public int getMinutes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(12);
    }

    public int getSeconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        return calendar.get(13);
    }

    public int SubstractDays(DateTime d) {
        long dist = (new DateTime(this.getYear(), this.getMonth(), this.getDay())).ms - (new DateTime(d.getYear(), d.getMonth(), d.getDay())).ms;
        return (int)((double)dist * 1.0D / 8.64E7D);
    }

    public long SubstractMiliSeconds(DateTime d) {
        return this.ms - d.ms;
    }

    public int SubstractSeconds(DateTime d) {
        return (int)((this.ms - d.ms) / 1000L);
    }

    public int SubstractMinutes(DateTime d) {
        return (int)((this.ms - d.ms) / 60000L);
    }

    public int SubstractHours(DateTime d) {
        return (int)((this.ms - d.ms) / 3600000L);
    }

    public int SubstractWeeks(DateTime d) {
        DateTime d1 = this.addFirstdayOfWeek(0);
        DateTime d2 = d.addFirstdayOfWeek(0);
        long dist = (new DateTime(d1.getYear(), d1.getMonth(), d1.getDay())).ms - (new DateTime(d2.getYear(), d2.getMonth(), d2.getDay())).ms;
        return (int)(dist / 604800000L);
    }

    public DateTime getDatePart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.ms);
        int year = calendar.get(1);
        int month = calendar.get(2);
        int date = calendar.get(5);
        return new DateTime(year, month, date, 0, 0, 0);
    }

    public int SubstractMonths(DateTime d) {
        return this.getYear() * 12 + this.getMonth() - (d.getYear() * 12 + d.getMonth());
    }

    public int SubstractYears(DateTime d) {
        return this.getYear() - d.getYear();
    }

    public boolean before(DateTime d) {
        return this.ms > d.ms;
    }

    public boolean after(DateTime d) {
        return this.ms < d.ms;
    }

    public long getTime() {
        return this.ms;
    }

    public Date getDate() {
        return this.dt;
    }

    public boolean isDatePartEquals(DateTime dateTime) {
        DateTime d1 = this.getDatePart();
        DateTime d2 = dateTime.getDatePart();
        return d1.getTime() == d2.getTime();
    }

    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fmt.format(this.dt);
    }

    public String toString(String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(this.dt);
    }

    public int hashCode() {
        return this.dt.hashCode();
    }
}
