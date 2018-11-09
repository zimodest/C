package www.jin.java11_7;


/**
 * 继承Thread实现多线程
 */

class MyThread1 extends Thread{
    private String string;
    public MyThread1(String string){
        this.string =string;
    }
    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println(this.string+",i="+i);
        }
    }
}

/**
 * 实现Runnable接口实现多线程
 */
class MyThread2 implements Runnable{
    private String string;
    public MyThread2(String string){
        this.string =string;
    }
    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println(this.string+",i="+i);
        }
    }
}



public class MyThreadTest {
    public static void main(String[] args) {
        /**
         * lambda表达式只能用于只有一个抽象方法的接口
         */
        //1
        Runnable runnable = ()-> System.out.println("hello java");
        new Thread(runnable).start();
        //2
        new Thread(()->System.out.println("hello java")).start();
    }
}
