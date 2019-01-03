
package com.me.note.test;

import com.me.note.common.TestModle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TestOperateFiles extends TestModle {
    @Override
    public void testAll() {
        testInputStream();
    }

    private void testInputStream(){
        try {
            //建立链接
            InputStream input = new FileInputStream("./test-files/inputStream.txt");

            //读取信息放入一个指定长度的字节数组中
            byte[] b = new byte[input.available()];
            int size = input.read(b);

            //输出信息
            System.out.println(Arrays.toString(b));
            System.out.println(new String(b, "utf-8") + "\nsize=" + size);

            //关闭流
            input.close();

        } catch (FileNotFoundException e){
            System.out.println("This file does not exist." + e);
        } catch (IOException e){
            System.out.println("Read/write files exception." + e);
        }
    }
}
