
package com.me.note.test;

import com.me.note.common.TestModle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestList extends TestModle {
    @Override
    public void testAll() {
        testRemoveRepeat();
    }

    private void testRemoveRepeat(){
        List<String> repeatList = new ArrayList<>();
        repeatList.add("1");
        repeatList.add("2");
        repeatList.add("10");
        repeatList.add("2");

        System.out.println(repeatList);
        repeatList = new ArrayList<>(new HashSet<>(repeatList));
        System.out.println(repeatList);
    }
}
