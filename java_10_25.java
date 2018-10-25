import java.util.*;
import java.lang.*;
// //接口设计模式-代理设计模式
// interface ISubject{
//     public void buyComputer(); //核心功能是买电脑
// }

// class RealSubject implements ISubject{
//     public void buyComputer(){
//         System.out.println("2.买一台外星人电脑");
//     }
// }

// class ProxySubject implements ISubject{
//     private ISubject subject;
//     public ProxySubject(ISubject subject){
//         this.subject = subject;
//     }
//     public void produceComputer(){
//         System.out.println("1.生产外星人电脑");
//     }
//     public void afterSale(){
//         System.out.println("3.外星人电脑售后团队");

//     }
//     public void buyComputer(){
//         this.produceComputer();//真实操作前的准备
//         this.subject.buyComputer();//调用真实业务
//         this.afterSale();//操作后的收尾
//     }
// }
// class Factory{
//     public static ISubject getInstance(){
//         return new ProxySubject(new RealSubject());
//     }
// }


// public class java_10_25{
//     public static void main(String[] args){
//         ISubject subject = Factory.getInstance();
//         subject.buyComputer();
//     }
// }



public class java_10_25{
    public static void main(String[] args){
        //String类的两种实例化方式
        //直接赋值
        String str = "Hello World"; //str是一个对象，"Hello Bit"就应该保存在堆内存中
        //传统方法
        String str1 = new String("Hello World");

        //字符串的比较
        //==：进行的数值比较，比较的是两个字符串对象的内存地址数值。 
        //2. “equals（）”：可以进行字符串内容的比较

        System.out.println(str == str1);//返回值 false 引用的比较
        System.out.println(str.equals(str1));//返回值 true 引用内容的比较
    }
}