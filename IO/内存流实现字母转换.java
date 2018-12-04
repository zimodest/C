package www.IO;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileTest {
    public static void main(String[] args) throws Exception {
	//内存流实现字母转换
        String msg = "hello";

        //取得内存流
        ByteArrayInputStream input = new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int len = 0;
        while((len = input.read()) != -1){
            out.write(Character.toUpperCase(len));
        }
        //直接将内存流输出
        System.out.println(out);

    }

    public static void Change(){
        //内存流实现字母转换
        String msg = "hello";

        //取得内存流
        ByteArrayInputStream input = new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int len = 0;
        while((len = input.read()) != -1){
            out.write(Character.toUpperCase(len));
        }
        //直接将内存流输出
        System.out.println(out);
    }
    }

