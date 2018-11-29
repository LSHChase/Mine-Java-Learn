/*
 * ------------------------------------------------------------------
 * Copyright © 2018 DtDream Science and Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *       Product: ASR
 *   Module Name: alarm-rule
 *  Date Created: 2018-11-23
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018-11-23      sx-9524
 * ------------------------------------------------------------------
 */
package com.me.note.test;

import com.me.note.common.StaticFunction;

public class TestStatic extends StaticFunction {
    private static TestStatic testStatic = new TestStatic();

    public void testFunction(){
        init();
        testDo();
    }

    //初始化
    public static void init(){
        testStatic.printNum("1");
        testStatic.printNum("2");
        testStatic.printNum("3");
    }

    //do thing
    public void testDo(){
        testStatic.doThings("create entity");
    }
}
