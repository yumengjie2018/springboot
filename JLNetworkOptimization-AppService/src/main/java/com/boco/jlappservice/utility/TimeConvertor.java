package com.boco.jlappservice.utility;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 时间比较器
 * 
 * @author pangkang 2018-1-26 15:11:59
 * @Modefy 将类改为时间转换相关类 2018-2-1 16:41:33
 * @author yumengjie 2018-3-27 10:11:22
 */
public class TimeConvertor {

    // 时间串正则表达式 hh:mm:ss
    private static Pattern pattern = Pattern.compile("([01]\\d|2[0-3]|\\d):([0-5]\\d):([0-5]\\d)");

    private static String formatError = "时间格式错误";
    private static String dateFormatString = "yyyy-MM-dd";
    private static String timeFormatString = "yyyy-MM-dd HH:mm:ss";
    private static String serialNoFormatString = "yyyyMMddHHmmss";
    private static String weekFormatString = "EEEE";
    private static String hourFormateString = "HH:mm:ss";
    private static int parseLocation = 0;

    /**
     * 该方法实现时间比对
     * 
     * @param init
     *            需要比较的日期，(yyyy-MM-dd HH:mm:ss) long
     * @param des
     *            规则(HH:mm:ss) String: 08:00:00
     * @param desDate
     *            规则(yyyy-MM-dd) String: 2018-01-01
     * @return 比较结果 将des 和desDate拼成yyyy-MM-dd HH:mm:ss形式，与init作比较
     * @throws Exception
     *             2018-2-1 17:08:32 pk
     */
    public static long compare(long init, String des, String desDate) throws Exception {

        Matcher matcher = pattern.matcher(des);
        if (!matcher.matches()) {
            throw new Exception(formatError);
        }
        String date = desDate.concat(" ").concat(des);
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatString);
        long dateLong = sdf.parse(date).getTime();
        return init - dateLong;
    }

    public static String getNextDay(String today) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = formatter.parse(today);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(todayDate);
        calendar.add(Calendar.DATE, 1);// 把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        Date nextDate = calendar.getTime();
        return formatter.format(nextDate);
    }

    public static String getDeltaString(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    public static boolean isBeforeToday(String today, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString);
        Date todayDate = sdf.parse(today);
        Date dateDate = sdf.parse(date);
        return dateDate.before(todayDate);
    }

    public static boolean isAfterToday(String today, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString);
        Date todayDate = sdf.parse(today);
        Date dateDate = sdf.parse(date);
        return dateDate.after(todayDate);
    }

    public static boolean isBeforeDateTime(String time1, String time2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatString);
        Date todayDate = sdf.parse(time1);
        Date dateDate = sdf.parse(time2);
        return dateDate.before(todayDate);
    }

    // 获取今天的时间
    public static String getTodayTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatString);
        long start = System.currentTimeMillis();
        String time = sdf.format(start);
        return time;
    }

    // 获取今天的日期
    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString);
        long start = System.currentTimeMillis();
        String date = sdf.format(start);
        return date;
    }

    // 获取序列号
    public static String getSerialNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat(serialNoFormatString);
        long start = System.currentTimeMillis();
        String number = sdf.format(start);
        return number;
    }

    /**
     * 根据日期获取星期几
     * 
     * @param dateString
     *            日期格式 "yyyy-mm-dd"
     * @return 星期几
     */
    public static String getWeekStringByDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatString);
        ParsePosition pos = new ParsePosition(parseLocation);
        Date date = formatter.parse(dateString, pos);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return new SimpleDateFormat(weekFormatString).format(c.getTime());
    }

    public static ArrayList<String> getPreMonthList(int count) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -(count - 1));
        String before_six = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH);// N个月前
        ArrayList<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(before_six));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(sdf.format(new Date())));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        Collections.reverse(result);
        return result;
    }

    // 由日期得到月
    public static String getMonth(String day) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        Date month = formatter.parse(day);
        return formatter.format(month);
    }

    public static String getWorkTime(String onDutyTime, String offDutyTime) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date onDuty = formatter.parse(onDutyTime);
        Date offDuty = formatter.parse(offDutyTime);
        long diff = offDuty.getTime() - onDuty.getTime();
        return getSwitchTime(diff);
    }

    public static String getSwitchTime(long diff) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;

        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return hour + "小时" + min + "分钟";
    }

    // 获取今天至月末的日期
    public static List<String> collectLocalDates() throws ParseException {

        String today = getTodayDate();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));// 月末
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = sdf.format(calendar.getTime());

        return collectLocalDates(LocalDate.parse(today), LocalDate.parse(lastDay));
    }

    // 获取两个时间段之间的日期
    public static List<String> collectLocalDates(LocalDate start, LocalDate end) {
        return Stream.iterate(start, localDate -> localDate.plusDays(1)).limit(ChronoUnit.DAYS.between(start, end) + 1)
                .map(LocalDate::toString).collect(Collectors.toList());
    }

    public static String getTimeMatcher(String des, String desDate) throws Exception {
        Matcher matcher = pattern.matcher(des);
        if (!matcher.matches()) {
            throw new Exception(formatError);
        }
        String date = desDate.concat(" ").concat(des);
        return date;
    }

    // 本月之后
    public static boolean isAfterMonth(String today, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date todayDate = sdf.parse(today);
        Date dateDate = sdf.parse(date);
        return dateDate.after(todayDate);
    }


    /**
     * 判断是否在某时刻之前 例如判断当前是否在9:00之前
     * pangkang
     * 2018-6-11 09:33:26
     * @param certainTime 被判断的时间 "09:00:00"
     * @return bool值
     */
    public static boolean isBeforeCertainClock(String certainTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(hourFormateString);
        Date certainTimeDate = sdf.parse(certainTime);
        long start = System.currentTimeMillis();
        String date = sdf.format(start);
        Date dateDate = sdf.parse(date);
        return dateDate.before(certainTimeDate);
    }
}
