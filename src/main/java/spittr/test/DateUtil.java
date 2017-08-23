package spittr.test;


import org.omg.CORBA.StringHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaosy-c on 2017/8/2.
 */



public class DateUtil {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatDate(Date date){
        return sdf.format(date);
    }


    public static String getDate(String time){
        if(null != time){
            return time.substring(0, 10);
        }
        return null;
    }

    public static String getYear(String time){
        if(null != time){
            return time.substring(0, 4);
        }
        return null;
    }

    public static String getMonth(String time){
        if(null != time){
            return time.substring(5, 7);
        }
        return null;
    }

    public static String getTimeStr(long time){
        Date date = new Date(time);
        return sdf.format(date);
    }

    public static Long getTime(String dateStr){
        try {
            return sdf.parse(dateStr).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Long getDateTime(String dateStr){
        try {
            return sdf1.parse(dateStr).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateStr(Date date){
        return sdf1.format(date);
    }

    public static Date getDateByString(String dateStr){
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当天天最小时间
     *
     * @param day
     * @return
     */
    public static long getDayMinTime(String day) {
        String yesterdayMinStr = day + " 00:00:00";
        try {
            return sdf.parse(yesterdayMinStr).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0l;
    }

    /**
     * 当天最大时间
     *
     * @param day
     * @return
     */
    public static long getDayMaxTime(String day) {
        String yesterdayMaxStr = day + " 23:59:59";
        try {
            return sdf.parse(yesterdayMaxStr).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new Date().getTime();
    }


    public static String getDayMinStr(String date) {
        return  date+ " 00:00:00";
    }


    public static String getDayMaxStr(String date) {
        return  date + " 23:59:59";
    }

    /**
     * 获取日期区间
     * @param begin 时间格式为yyyy-MM-dd
     * @param end   时间格式为yyyy-MM-dd
     * @return
     */
    public static List<String> interval(String begin, String end){
        List<String> result = new ArrayList<>();
//        Calendar startDate = Calendar.getInstance();
//        startDate.set(Integer.valueOf(begin.split("-")[0]),Integer.valueOf(begin.split("-")[1])-1, Integer.valueOf(begin.split("-")[2]));
//        Long startTIme = startDate.getTimeInMillis();
        Long startTIme = getDateTime(begin);

//        Calendar endDate = Calendar.getInstance();
//        endDate.set(Integer.valueOf(end.split("-")[0]),Integer.valueOf(end.split("-")[1])-1, Integer.valueOf(end.split("-")[2]));
//        Long endTime = endDate.getTimeInMillis();
        Long endTime = getDateTime(end);

        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            result.add(sdf1.format(d));
            time += oneDay;
        }
        return result;
    }

    public static String getToday(){
        return sdf1.format(new Date());
    }

    public static String getYesterday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return DateUtil.getDateStr(cal.getTime());
    }

    public static String getTheDayBeforeYesterday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        return DateUtil.getDateStr(cal.getTime());
    }

    public static String getMonByDate(String date){
        return date.split("-")[0]+date.split("-")[1];
    }

    public static String getNextDate(String date){
        Calendar startDate = Calendar.getInstance();
        startDate.set(Integer.valueOf(date.split("-")[0]),Integer.valueOf(date.split("-")[1])-1, Integer.valueOf(date.split("-")[2]));
        Long startTIme = startDate.getTimeInMillis();
        Long oneDay = 1000 * 60 * 60 * 24l;
        startTIme += oneDay;
        return sdf1.format(startTIme);
    }

    public static void main(String[] args) {
        DateUtil util = new DateUtil();
        Date date = new Date();
        String dateStr = util.formatDate(date);
        String begin = "2017-08-01";
        String end = "2017-08-30";
//        Date begindate  = getDateByString(begin);
//        Long beginlong = getDateTime(begin);
//        System.out.println(begindate.toString());
//        Date date1 = new Date(beginlong);
//        System.out.println(beginlong);
//        System.out.println(date1.toString());


        List<String> res = interval(begin, end);
        System.out.println(res.toString());
//        Long date1 = util.ge(str);
//        System.out.println(date1);
//        System.out.println(dateStr);
    }

}
