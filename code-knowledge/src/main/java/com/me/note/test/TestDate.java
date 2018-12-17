
package com.me.note.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    public void testAll(){
        testSimpleDateFormat();
    }

    private void testSimpleDateFormat(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        String weekDay = dateFormat.format(date);
        System.out.println(weekDay);
    }
}
