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
package com.me.note.test;

import com.me.note.common.TestModle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex extends TestModle {

    @Override
    public void testAll(){
//        testRegulation();
//        testMail();
        testTime();
    }

    //测试规则内容
    private void testRegulation(){
        //可能出现的规则内容数组
        List<String> regulationArray = new ArrayList<>();
        //单项缺少组成部分
            regulationArray.add("");
            regulationArray.add("PROTECT_RPO");
            regulationArray.add("<");
            regulationArray.add("100");
            regulationArray.add("PROTECT_RPO>");
            regulationArray.add(">100");
            regulationArray.add("PROTECT_RPO100");
            regulationArray.add("jkdsafop4909f");
            regulationArray.add("PROTECT_RPO&&100");
        //单项不缺少组成部分
            regulationArray.add("你好>你不好");
            regulationArray.add("PROTECT_RPO<>100");
            regulationArray.add("PROTECT_RPO<1>100");
            regulationArray.add("PROTECT_RPO><<><100");
            regulationArray.add("PROTECT_RPO>D101");
            regulationArray.add("PROTECT_RPO>10>10");
            regulationArray.add("100=2100");

            regulationArray.add("!(RPO>10&RPO<100)|(STATE=FAIL)");

        String regex = "^(\\w+)([!><=]+)(.+)$";
        String regex1 = "^(\\w+)([:]?[>]?[<]?[=]?)(.+)$";
        String regex2 = "^([(!]*)(\\w+)([!:><=]+)(\\w+)(([()!&|]+)(\\w+)([!:><=]+)(\\w+))*(\\)*)$";
        String regex3 = "^([^&|!]+)([&|!]+)([&|!]+)$";
        Pattern pattern = Pattern.compile(regex);
            for (String regulation: regulationArray) {
            Matcher matcher = pattern.matcher(regulation);

            if (!matcher.find()) {
                System.out.println(regulation);
                System.out.println(matcher.find());
            } else {
                for (int i =0; i <= matcher.groupCount(); i++) {
    //                    if (null != matcher.group(i)) {
                    System.out.println(matcher.group(i));
    //                    }
                }
            }

            System.out.println("---------------分割线---------------");
        }
    }

    //测试IP，域名和邮箱地址
    private void testMail(){
        List<String> ipDomainList = new ArrayList<>();
        ipDomainList.add("adnujaf");

        //错误IP地址
        ipDomainList.add("");
        ipDomainList.add("10.");
        ipDomainList.add("10.157");
        ipDomainList.add("10.157.");
        ipDomainList.add("10.157.138");
        ipDomainList.add("10.157.138.");
        ipDomainList.add("10.157.138.254.");
        ipDomainList.add("10.157.138.254.168.135");
        ipDomainList.add("260.255.255.255");
        ipDomainList.add("255.260.255.255");
        ipDomainList.add("-1.255.255.255");

        /**错误的域名
         * 域名可以由（a-z、A-Z大小写等价）26个英文字母、数字（0-9）以及连接符“-”组成，但是域名的首位必须是字母或数字。
         * 对于域名的长度也有一定的限制：国际通用顶级域名长度不得超过26个字符，中国国家顶级域名长度不得超过20个字符
         */
        ipDomainList.add("&.cn");
        ipDomainList.add("cn.&");
        ipDomainList.add("&.&");
        ipDomainList.add("-ma.cn");
        ipDomainList.add("ma.-ma.cn");
        ipDomainList.add("smtp.qq.comjflkasdgkjsdfasjkf");

        //正确IP地址和域名
        ipDomainList.add("10.157.138.254");
        ipDomainList.add("smtp.qq.com");


        String ipRegex = "^(((((25[0-5])|2[0-4][0-9]|((1[0-9]{2})|(0?[0-9]?[0-9])))\\.){3})(25[0-5]|2[0-4][0-9]|((1[0-9]{2})|(0?[0-9]?[0-9]))))$";
//        String ipRegexMe = "^((([0-1]?[0-9]{1,2})|(2[0-5][])\\.){3}([0-1]?[0-9]{1,2})|(2[0-5]{2})$";
        String domainRegex = "^[0-9a-zA-Z]+[0-9a-zA-Z\\.-]*\\.[a-zA-Z]{2,4}$";
//        ng-pattern='/^(([0-5]?[0-9]{0,4})|(6(([0-4][0-9]{3})|(5(([0-4][0-9]{2})|(5(([0-2][0-9])|(3[0-5]))))))))$/'

        Pattern pattern = Pattern.compile(ipRegex);
        for (String ipDomain: ipDomainList){
            Matcher matcher = pattern.matcher(ipDomain);
            if (!matcher.find()){
                System.out.println(ipDomain + "\n" + matcher.find());
            }else {
                System.out.println(ipDomain + "\n" + matcher.find());
            }
        }
    }

    //测试时分秒
    private void testTime(){

        String[] times = {"10:00", "00:00", "1:59", "23:59", "24:00", "12:60", "13:99", "7:66", "08:49", "?9:00"};

        String regex = "^((([01]?[0-9])|(2[0-3])):([0-5][0-9]))$";

        Pattern pattern = Pattern.compile(regex);
        for (String time: times) {
            Matcher matcher = pattern.matcher(time);
            System.out.println(time + ": " +matcher.find());
        }

    }
}
