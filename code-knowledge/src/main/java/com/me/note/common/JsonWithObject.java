/*
 * ------------------------------------------------------------------
 * Copyright © 2018 DtDream Science and Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *       Product: ASR
 *   Module Name: alarm-rule
 *  Date Created: 2018-11-13
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018-11-13      sx-9524
 * ------------------------------------------------------------------
 */
package com.me.note.common;

import com.me.note.entity.Rule;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonWithObject {

    public void testAllEvent(){
        json2Object();
    }

    //json转对象
    private void json2Object(){
        String ruleJson = "{\n" +
                "   \"ruleId\":\"4d8e5f45-0430-4e60-9291-503e6e8dc808\",\n" +
                "   \"ruleName\":\"\",\n" +
                "   \"userIds\":\"\"\n" +
                "}\n";
//        System.out.println(ruleJson);

        ObjectMapper mapper = new ObjectMapper();
        try {
            Rule rule = mapper.readValue(ruleJson, Rule.class);
//            System.out.println(rule.toString());
            if (null == rule.getRuleName()){
                System.out.println("空对象");
            }
            if ("".equals(rule.getRuleName())){
                System.out.println("空字符串");
            }
        }catch (Exception e){
            System.out.println("有异常\n"+ e);
        }
    }
}
