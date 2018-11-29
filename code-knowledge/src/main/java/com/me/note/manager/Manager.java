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
package com.me.note.manager;

import com.me.note.common.CalculationResults;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Manager {

    public CalculationResults analysisCalcuteStr(String str, Map<String, Object> value){
        CalculationResults calculationResults = new CalculationResults();

        //从规则中抽出每条监控属性存数组
        List<String> itemConfigs = takeOutEachConfig(str);
        for (String item: itemConfigs){
//            if (item.contains(value.keySet())){
////                calculationResults = rpoMax(str.replace("MAX_RPO", ""), (Integer)value.get("MAX_RPO"));
////            }
////            if ()
        }

        //对每条监控属性做计算

        List<String> itemList = getAlarmItem(str);
        for (String item: itemList){
            switch (item){
                case "MAX_RPO":
                    calculationResults = rpoMax(str.replace("MAX_RPO", ""), (Integer)value.get("MAX_RPO"));
                    break;
                case "PROTECT_STATUS":
                    calculationResults = protectStatus(str.replace("PROTECT_STATUS=", ""), (String)value.get("PROTECT_STATUS"));
                default :
                    break;
            }
        }

        return calculationResults;

    }

    //从regulation中抽出每条属性
    public List<String> takeOutEachConfig(String str){
        List<String> configs = new ArrayList<>();
        char[] ch = str.toCharArray();
        int i = 0, j = 0;
        for ( ; i < ch.length; i++){
            if (ch[i] == '!' || ch[i] == '&' || ch[i] == '|'){
                //j随着每条数据的添加而变化
                if (j < i) {
                    configs.add(str.substring(j, i));
                    j = i;
                }
                if ((ch[i + 1] >= 'a' && ch[i + 1] <= 'z')
                        || (ch[i + 1] >= 'A' && ch[i + 1] <= 'Z') || ch[i + 1] == '_'){
                    j = i + 1;
                }
            }
        }
        if (j < i){
            configs.add(str.substring(j, i));
        }

        return configs;
    }

    public CalculationResults rpoMax(String operatorValue, Integer value){
        CalculationResults results = new CalculationResults();
        int surpass = 0;

        if (operatorValue.contains(">=")){
            if (value >= Integer.parseInt(operatorValue.replace(">=", ""))){
                results.setWhetherToAlarm(true);
                surpass = value - Integer.parseInt(operatorValue.replace(">=", ""));
            }
        }else if (operatorValue.contains(">")){
            if (value > Integer.parseInt(operatorValue.replace(">", ""))){
                results.setWhetherToAlarm(true);
                surpass = value - Integer.parseInt(operatorValue.replace(">", ""));
            }
        }else if (operatorValue.contains("=")){
            if (value == Integer.parseInt(operatorValue.replace("=", ""))){
                results.setWhetherToAlarm(true);
                surpass = value - Integer.parseInt(operatorValue.replace("=", ""));
            }
        }

        results.setAlarmContent("Rule: MAX_RPO" + operatorValue + "," + "Now: MAX_RPO=" + value
                + "<" + "Surpass rule RPO: " + surpass + ">");

        return results;
    }

    public CalculationResults protectStatus(String value, String status){
        CalculationResults results = new CalculationResults();
        results.setAlarmContent("Rule: PROTECT_STATUS=" + value + "," + "Now: PROTECT_STATUS=" + status);

        if (value.equals(status)){
            results.setWhetherToAlarm(true);
        }

        return results;
    }

    public List<String> getAlarmItem(String str){
        List<String> itemList = new ArrayList<>();
        List<String> itemConfigs = takeOutEachConfig(str);

        for (String config: itemConfigs){
            if (config.contains(">=")){
                itemList.add(StringUtils.substringBefore(config, ">="));
            }else if (config.contains(">")){
                itemList.add(StringUtils.substringBefore(config, ">"));
            }else if (config.contains("=")){
                itemList.add(StringUtils.substringBefore(config, "="));
            }
        }

        HashSet hashSet = new HashSet(itemList);
        itemList.clear();
        itemList.addAll(hashSet);
        return itemList;
    }
}
