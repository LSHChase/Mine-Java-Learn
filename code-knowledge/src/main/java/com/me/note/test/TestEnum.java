
package com.me.note.test;

import com.me.note.common.NewEnum;
import com.me.note.common.TestModle;

public class TestEnum extends TestModle {

    @Override
    public void testAll(){
        testEnumName();
    }

    private void testEnumName(){
        System.out.println(NewEnum.NIHAO.getName());
    }
}
