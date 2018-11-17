package www.jin.javapratice;

/**
 * 1.写两个线程，一个线程打印 1~52，另一个线程打印A~Z，
 * 打印顺序是12A34B...5152Z；
 */
/**
 * 信号量
 */
//class MyThread3{
//    int i;
//    char c;
//    public synchronized void PrintNum() {
//            for(i = 1; i <= 52; i++) {
//                System.out.println(i);
//                if (i % 2 != 1) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                notify();
//            }
//    }
//
//    public synchronized void PrinChar() {
//            for (c = 'A'; c <= 'Z'; c++) {
//                System.out.println(c);
//                notify();
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//    }
//}
//
//class Thread1 implements Runnable{
//    private MyThread3 myThread3;
//    public Thread1(MyThread3 myThread3){
//        this.myThread3 = myThread3;
//    }
//    @Override
//    public void run() {
//        myThread3.PrintNum();
//    }
//}
//
//class Thread2 implements Runnable{
//    private MyThread3 myThread3;
//    public Thread2(MyThread3 myThread3){
//        this.myThread3 = myThread3;
//    }
//    @Override
//    public void run() {
//        myThread3.PrinChar();
//    }
//}
//
//public class DaYin1Test {
//    public static void main(String[] args) throws InterruptedException {
//        MyThread3 myThread3 = new MyThread3();
//        Thread2 thread2 = new Thread2(myThread3);
//        Thread1 thread1 = new Thread1(myThread3);
//        new Thread(thread1).start();
//        Thread.sleep(20);
//        new Thread(thread2).start();
//    }
//}

/**
 * 1.写两个线程，一个线程打印 1~52，另一个线程打印A~Z，
 * 打印顺序是12A34B...5152Z；
 */
/**
 * 信号量
 */
class Print{
    private int flag = 1;
    private int count = 1;

    public synchronized void PrintNum(){
        if(flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(2*count -1);
        System.out.println(2*count);
        notify();
        flag = 2;
    }
    public synchronized void PrintChar(){
        if(flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println((char)(count-1+'A'));
        count = count+1;
        notify();
        flag = 1;
    }
}

class PrintNum implements Runnable{
    private Print print;
    public PrintNum(Print print) {
        this.print = print;
    }


    @Override
    public void run() {
        print.PrintNum();
    }
}

class PrintChar implements Runnable{
    private Print print;
    public PrintChar(Print print) {
        this.print = print;
    }


    @Override
    public void run() {
        print.PrintChar();
    }
}

//少个循环
public class DaYin1Test{
    public static void main(String[] args) {
        Print print = new Print();
        PrintNum printNum = new PrintNum(print);
        PrintChar printChar = new PrintChar(print);
        new Thread(printNum).start();
        new Thread(printChar).start();
    }
}




















