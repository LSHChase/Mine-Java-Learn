
package com.me.note.test;

import com.me.note.common.TestModle;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TestString extends TestModle {
    @Override
    public void testAll() {
//        testSubString();
        testParseInt();
    }


    private void testSubString(){
        //截取空字符串之前的字符
        String str = "partNum:1 eTag:2-md5 size:100 time:1546480800000";
        Map<String, String> lineMap = new HashMap<>();
        for (String parameter: StringUtils.split(str, " ")){
//            System.out.println(parameter);
            lineMap.put(parameter.substring(0, parameter.indexOf(":")), parameter.substring(parameter.indexOf(":") + 1));
        }
        System.out.println("partNum=" + Integer.parseInt(lineMap.get("partNum")) + "\n" +
                "eTag=" + lineMap.get("eTag") + "\n" +
                "size=" + lineMap.get("size") + "\n" +
                "time=" + new Date(Long.parseLong(lineMap.get("time"))));
    }

    private void testParseInt(){
        Integer num = 1000;
        String numStr = num.toString();

        List<String> strs = new ArrayList<>(Arrays.asList(StringUtils.split("1,2,3,4,5,6", ",")));
        strs.removeAll(Arrays.asList(StringUtils.split("1,2", ",")));

        System.out.println(Arrays.toString(strs.toArray()));
    }
}
