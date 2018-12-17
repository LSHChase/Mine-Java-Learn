/*
 * ------------------------------------------------------------------
 * Copyright © 2018 DtDream Science and Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *       Product: ASR
 *   Module Name: alarm-rule
 *  Date Created: 2018-11-16
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018-11-16      sx-9524
 * ------------------------------------------------------------------
 */
package com.me.note.test;

import com.alibaba.fastjson.JSONObject;
import com.me.note.entity.Rule;

public class TestMap {
    public void testAll(){
//        object2Map();
        test();
    }


    private void object2Map(){
        Rule rule = new Rule();
        rule.setRuleId("1");
        rule.setRuleName("2");
        rule.setUserIds("1");
        Object object = JSONObject.toJSONString(rule);
//        Map<String, Object> map = object;
//        try {
//            Field[] declaredFields = object.getClass().getDeclaredFields();
//            for (Field field : declaredFields) {
//                field.setAccessible(true);
//                if (field.get(object) != null && !"".equals(field.get(object).toString())) {
//                    map.put(field.getName(), field.get(object));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println(map.toString());
    }


    public void test(){

        Object json = "{\n" +
                "    \"departmentId\": \"1\",\n" +
                "    \"departmentName\": \"全部\",\n" +
                "    \"comment\": \"整个平台的根部门，超级管理员和系统管理员属于该部门，全平台唯一\",\n" +
                "    \"level\": 0,\n" +
                "    \"isIndependent\": true,\n" +
                "    \"children\": [{\n" +
                "      \"departmentId\": \"3\",\n" +
                "      \"departmentName\": \"asr_back_dep\",\n" +
                "      \"parentId\": \"1\",\n" +
                "      \"parentLabel\": \"root\",\n" +
                "      \"level\": 1,\n" +
                "      \"isIndependent\": true,\n" +
                "      \"children\": [{\n" +
                "        \"departmentId\": \"7\",\n" +
                "        \"departmentName\": \"dep_dep_son1\",\n" +
                "        \"parentId\": \"3\",\n" +
                "        \"parentLabel\": \"asr_back_dep\",\n" +
                "        \"level\": 2,\n" +
                "        \"isIndependent\": true,\n" +
                "        \"children\": [{\n" +
                "          \"departmentId\": \"8\",\n" +
                "          \"departmentName\": \"dep_dep_son_son1\",\n" +
                "          \"parentId\": \"7\",\n" +
                "          \"parentLabel\": \"dep_dep_son1\",\n" +
                "          \"level\": 3,\n" +
                "          \"isIndependent\": true,\n" +
                "          \"children\": [],\n" +
                "          \"departmentType\": \"PRIVATE\",\n" +
                "          \"relationChain\": \"1<3<7\",\n" +
                "          \"operationUnitId\": \"1\",\n" +
                "          \"operationUnitName\": \"default\"\n" +
                "        }],\n" +
                "        \"departmentType\": \"PRIVATE\",\n" +
                "        \"relationChain\": \"1<3\",\n" +
                "        \"operationUnitId\": \"1\",\n" +
                "        \"operationUnitName\": \"default\"\n" +
                "      }],\n" +
                "      \"departmentType\": \"PRIVATE\",\n" +
                "      \"relationChain\": \"1\",\n" +
                "      \"operationUnitId\": \"1\",\n" +
                "      \"operationUnitName\": \"default\"\n" +
                "    }, {\n" +
                "      \"departmentId\": \"4\",\n" +
                "      \"departmentName\": \"asr_back_system_dep\",\n" +
                "      \"parentId\": \"1\",\n" +
                "      \"parentLabel\": \"root\",\n" +
                "      \"level\": 1,\n" +
                "      \"isIndependent\": true,\n" +
                "      \"children\": [{\n" +
                "        \"departmentId\": \"5\",\n" +
                "        \"departmentName\": \"system_dep_son1\",\n" +
                "        \"parentId\": \"4\",\n" +
                "        \"parentLabel\": \"asr_back_system_dep\",\n" +
                "        \"level\": 2,\n" +
                "        \"isIndependent\": true,\n" +
                "        \"children\": [{\n" +
                "          \"departmentId\": \"6\",\n" +
                "          \"departmentName\": \"system_dep_son_son1\",\n" +
                "          \"parentId\": \"5\",\n" +
                "          \"parentLabel\": \"system_dep_son1\",\n" +
                "          \"level\": 3,\n" +
                "          \"isIndependent\": true,\n" +
                "          \"children\": [],\n" +
                "          \"departmentType\": \"PRIVATE\",\n" +
                "          \"relationChain\": \"1<4<5\",\n" +
                "          \"operationUnitId\": \"1\",\n" +
                "          \"operationUnitName\": \"default\"\n" +
                "        }],\n" +
                "        \"departmentType\": \"PRIVATE\",\n" +
                "        \"relationChain\": \"1<4\",\n" +
                "        \"operationUnitId\": \"1\",\n" +
                "        \"operationUnitName\": \"default\"\n" +
                "      }],\n" +
                "      \"departmentType\": \"PRIVATE\",\n" +
                "      \"relationChain\": \"1\",\n" +
                "      \"operationUnitId\": \"1\",\n" +
                "      \"operationUnitName\": \"default\"\n" +
                "    }, {\n" +
                "      \"departmentId\": \"2\",\n" +
                "      \"departmentName\": \"DTCenter开发部\",\n" +
                "      \"parentId\": \"1\",\n" +
                "      \"parentLabel\": \"root\",\n" +
                "      \"level\": 1,\n" +
                "      \"isIndependent\": true,\n" +
                "      \"children\": [],\n" +
                "      \"departmentType\": \"PRIVATE\",\n" +
                "      \"relationChain\": \"1\",\n" +
                "      \"operationUnitId\": \"1\",\n" +
                "      \"operationUnitName\": \"default\"\n" +
                "    }],\n" +
                "    \"operationUnitId\": \"1\",\n" +
                "    \"operationUnitName\": \"default\"\n" +
                "  }";
        JSONObject jsonObject = JSONObject.parseObject(json.toString());
        Object departmentId = jsonObject.get("departmentId");
        System.out.println(departmentId);
    }
}
