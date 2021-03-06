
package com.me.note.test;

import com.me.note.common.TestModle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TestDate extends TestModle {

    @Override
    public void testAll(){
      testPrintDate();
//        testSimpleDateFormat();
//        testZeroTime();
        //testDateFormat();
    }

    private void testPrintDate(){
        Date date = new Date(1548817980000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println(dateFormat.format(new Date()) + ":" + new Date());
        System.out.println(dateFormat.format(date) + ":" + date);
        System.out.println(date.getDay() + ":" + new Date().getDate());

        System.out.println("old " + date.getTime()/(24*3600*1000));
        date = new Date(date.getTime() - date.getTime() % (24*3600*1000) - 8*3600*1000);
        System.out.println("new " + date.getTime()/(24*3600*1000));
    }

    private void testSimpleDateFormat(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        for (int i = 0; i < 7; i ++) {
            String weekDay = dateFormat.format(new Date(date.getTime() + i*24*3600*1000));
            System.out.println(weekDay);
        }
    }

    private void testZeroTime(){
        Date date = new Date();
        long zeroTime = date.getTime() - date.getTime() % (24*3600*1000) - 8*3600*1000;

        String backupTime = "10:10";
        int backupHour = Integer.parseInt(backupTime.substring(0, backupTime.indexOf(":")));
        int backupMinute = Integer.parseInt(backupTime.substring(backupTime.indexOf(":") + 1));

        long triggerTime = zeroTime + backupHour*3600*1000L + backupMinute*60*1000L;

        System.out.println(new Date(zeroTime));
        System.out.println(new Date(triggerTime));
        System.out.println(new Date(triggerTime + 10*24*3600*1000));
    }

    //时区问题
    private void testDateFormat(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(dateFormat.format(new Date()));
    }
}
