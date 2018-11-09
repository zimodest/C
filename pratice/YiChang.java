package www.jin.java11_7;

/**
 * 5.编程:
 * 1).定义一个MulException类继承Exception类，要求两数相乘等于100报错，
 * 在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。
 * 2).定义一个DivException类继承RuntimeException类，要求两数相除等于2报错，
 * 在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。
 */
//受查异常
 //throw后要进行处理，放在try中
class MulException extends Exception{
    String string;
    MulException(String string){
        super(string);
    }
}
//非受查异常
class DivException extends RuntimeException{
    String string;
    public DivException(String string){
        super(string);
    }
}
public class YiChang {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
            if(2 == a / b){
                throw new DivException("两数相除等于2");
            }

    }
}
