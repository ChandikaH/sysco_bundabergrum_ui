package com.sysco.qe.bundabergrum.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(date);
        return currentDate;
    }

    public static String getPastDate(int numOfYears) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -numOfYears);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String pastDate = sdf.format(date);

        return pastDate;
    }

    public static String getFutureDate(int numOfDays) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String futureDate = sdf.format(date);

        return futureDate;
    }

    public static String getFutureDate(int numOfDays, String strFormat) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        String futureDate = sdf.format(date);

        return futureDate;
    }

    public static String getDayOfWeekOfGivenDate(String date) {
        String dayOfWeek = "";
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
            Date dt1 = format1.parse(date);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            dayOfWeek = format2.format(dt1);
        } catch (Exception e) {

        }
        return dayOfWeek;
    }
}
