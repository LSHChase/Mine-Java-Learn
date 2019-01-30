
package com.me.note.test;

import com.me.note.common.TestModle;
import com.me.note.common.Todo;

public class TestAnnotation extends TestModle {
    @Override
    public void testAll() {
        testBaseMethod();
    }
    @Todo(priority = Todo.Priority.MEDIUM, author = "LSHChase")
    private void testBaseMethod(){
        System.out.println("sss");
    }
}
