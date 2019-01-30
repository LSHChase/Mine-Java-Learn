
package com.me.note.test;

import com.me.note.common.TestModle;

import java.util.UUID;

public class TestUUID  extends TestModle {
    @Override
    public void testAll() {
        testGenerateUUID();
    }

    private void testGenerateUUID(){
        System.out.println(UUID.randomUUID().toString());
    }
}
