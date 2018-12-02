package www.multithreading;

import java.util.concurrent.ThreadLocalRandom;

class InterruptStopThread implements Runnable{
    @Override
    public void run() {
        int i = 0;
//       1 ****************************************************
//        while(true){
//            boolean bool = Thread.currentThread().isInterrupted();
//            System.out.println(Thread.currentThread().getName()
//            +"第"+i +"次执行");
//            System.out.println(bool);
//            if(bool){
//                System.out.println("线程退出..");
//                break;
//            }
//            i++;
//        }


//     2   ******************************************************************
        while(true){
            try {
                Thread.sleep(1000);
                boolean bool = Thread.currentThread().isInterrupted();
                if(bool) {
                    System.out.println("线程退出..");
                    break;
                }
                System.out.println(Thread.currentThread().getName()
                +"第"+i+"次执行....");
                System.out.println(bool);
                i++;
            } catch (InterruptedException e) {
                System.out.println("异常抛出，线程停止");
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println("Catch块中中断状态为"+bool);
                return;
            }
        }
    }
}

public class InterruptStopThreadTest {
    public static void main(String[] args) throws InterruptedException {
        InterruptStopThread interruptStopThread = new InterruptStopThread();
        Thread thread = new Thread(interruptStopThread,"子线程A");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
