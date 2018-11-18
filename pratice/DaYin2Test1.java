package www.jin.javapratice;

/**
 *2.编写一个程序，启动三个线程，三个线程的名称分别是 A，B，C；
 * 每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC...
 * notifyAll();
 *
 *3.写3个线程，打印如下
 * *Thread-0
 * *Thread-0@Thread-1
 * *Thread-0@Thread-1#Thread-2
 * *Thread-0@Thread-1#Thread-2*Thread-0
 * *Thread-0@Thread-1#Thread-2*Thread-0@Thread-1
 * *Thread-0@Thread-1#Thread-2*Thread-0@Thread-1#Thread-2
 * ...
 * 重复30次
 * StringBuffer ;
 */

class Print2{
    private int flag = 1;
    private int count = 1;
//    private int row = 1;


    public int getCount() {
        return count;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public synchronized void Print1(){
        if(flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        if(count%3 == 1){
//            System.out.println("*"+Thread.currentThread().getName());
//        }else{
            System.out.print("*"+Thread.currentThread().getName());
//        }
        count++;
        notifyAll();
//        flag = 2;
    }
    public synchronized void Print2(){
        if(flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        if(count%3 == 2){
//            System.out.println("@"+Thread.currentThread().getName());
//        }else{
            System.out.print("@"+Thread.currentThread().getName());
//        }
        count++;
        notifyAll();
//        flag = 3;
    }
    public synchronized void Print3(){
        if (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        if(count%3 == 1){
//            System.out.println("#"+Thread.currentThread().getName());
//        }else{
            System.out.print("#"+Thread.currentThread().getName());
//        }
        count++;
        notifyAll();
//        flag = 1;
    }
}

class PrintA implements Runnable{
    private Print2 print2;
    public PrintA(Print2 print2){
        this.print2 = print2;
    }
    @Override
    public void run() {

//        for(int i = 1; i<print2.getCount();i++) {
            for(int j = 1; j< 10; j++){
                print2.Print1();
                print2.setFlag(j);

            }



//        }
    }
}
class PrintB implements Runnable{
    private Print2 print2;
    public PrintB(Print2 print2){
        this.print2 = print2;
    }
    @Override
    public void run() {


            print2.Print2();



    }
}
class PrintC implements Runnable{
    private Print2 print2;
    public PrintC(Print2 print2){
        this.print2 = print2;
    }
    @Override
    public void run() {

            print2.Print3();

    }
}
public class DaYin2Test {
    public static void main(String[] args) {
        Print2 print2 = new Print2();


        PrintA printA = new PrintA(print2);
        PrintB printB = new PrintB(print2);
        PrintC printC = new PrintC(print2);

        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printC).start();

    }
}
