//1.组织域名的反转：比如：google.com  com.google
//2.个人开源项目 ： github,gitee  
//gitee.com/secondriver -> com.gitee.secondrive;   
//github.com/secondriver -> com.github.secondriver
//3.建议使用 a-z 0-9 字符，字母小写
package com.bittech;

//1.使用指定类导入方式
//import com.bittech.util.ArrayUtils;
//2.使用*的导入方式(只是在代码中正真使用到的时候才会加载)
import com.bittech.util.*;
//3.静态导入
//import static com.bittech.util.ArrayUtils.*;
import static com.bittech.util.ArrayUtils.A;
import static com.bittech.util.ArrayUtils.B;

public class Test {
 
    public static void main(String[] args){
        System.out.println("java is best");
        
        int[] array = new int[]{1,2,3,4};
        ArrayUtils.printArray(array);
        
        System.out.println(A);
        System.out.println(B);
        
    }
}

//private [default] protected 根据现实情况进行设置
class Father{
    
  
   protected int banlance = 10_000;
    
}

class Son extends Father{
    
    public void print(){
        System.out.println(banlance);
    }
}



