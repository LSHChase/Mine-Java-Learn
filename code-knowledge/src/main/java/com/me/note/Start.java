/*
 * ------------------------------------------------------------------
 * Copyright © 2018 DtDream Science and Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *       Product: ASR
 *   Module Name: alarm-rule
 *  Date Created: 2018-09-20
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018-09-20      sx-9524
 * ------------------------------------------------------------------
 */
package com.me.note;

import com.me.note.common.CalculationResults;
import com.me.note.manager.Manager;
import com.me.note.test.TestStatic;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args){
        Manager manager = new Manager();
        List<CalculationResults> resultsList = new ArrayList<>();

        //规则内容
        String str = "PROTECTED_GROUP_MAX_RPO>100||PROTECTED_GROUP_STATUS=FAILED||PLAN_RTO>10||MAX_RPO=10";

        //取出无重复的监控项列表
//        for (String item: manager.getAlarmItem(str)) {
//            System.out.println(item);
//        }

        //根据监控项列表获取数据并写入Map
        Map<String, Object> env = new HashMap<>();
        env.put("PROTECTED_GROUP_MAX_RPO", 1000);
        env.put("PROTECTED_GROUP_STATUS", "FAILED");
        env.put("PLAN_RTO", 100);
        env.put("LATEST_TASK_STATUS", 500);

        //计算一个：获取每一项内容并遍历计算，返回一个监控项是否告警布尔值和一个监控项内容
        //监控项内容: (true, "Rule: PROTECTED_GROUP_MAX_RPO>100, Now: PROTECTED_GROUP_MAX_RPO: 1000, <Surpass rule: 900>")
//        List<String> regulations = manager.takeOutEachConfig(str);
//        for (String config: regulations){
//            CalculationResults results = manager.analysisCalcuteStr(config, env);
//            if (results.getWhetherToAlarm()){
//                System.out.println("alarm");
//                System.out.println(results.getAlarmContent());
//            }
//
//        }

        //计算全部：将Map传入计算,返回一个监控对象是否告警布尔值和一个监控对象内容：包含多个监控项内容
        //监控对象内容：(true, "Rule: PROTECTED_GROUP_MAX_RPO>100||PROTECTED_GROUP_STATUS=FAILED||PLAN_RTO>10||MAX_RPO=10
        //                      Now: PROTECTED_GROUP_MAX_RPO: 1000, PROTECTED_GROUP_STATUS: FAILED, PLAN_RTO: 50
        //                      <PROTECTED_GROUP_MAX_RPO surpass rule: 900, PLAN_RTO surpass rule: 40>")

        //告警
//
//        calculationResults = manager.analysisCalcuteStr(str, protect);
//        if (calculationResults.getWhetherToAlarm()){
//            System.out.println("alarm");
//            System.out.println(calculationResults.getAlarmContent());
//        }


        //测试exception
        try{

        }catch (Exception e){
            logger.error("111" + e);
        }

        //测试regex
//        TestRegex testRegex = new TestRegex();
//        testRegex.testAllRegex();

        //测试json数据与对象的转换
//        JsonWithObject jsonWithObject = new JsonWithObject();
//        jsonWithObject.testAllEvent();

//        List<Map<String, String>> listMap = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();
//        map.put("m", "mm");
//        map.put("o", "oo");
//        map.put("v", "vv");
//        listMap.add(map);
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            System.out.println(mapper.writeValueAsString(listMap));
//        }catch (Exception e){
//            System.out.println("有异常");
//        }

//        TestMap testMap = new TestMap();
//        testMap.testAll();

        TestStatic testStatic = new TestStatic();
        testStatic.testFunction();
    }
}
