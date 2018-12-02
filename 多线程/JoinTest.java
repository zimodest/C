package www.multithreading;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 等待其他线程终止 join()
 * join方法只是对Object提供的wait()做了一层包装而已
 * 等待线程其他线程终止，如果在主线程中调用该方法会让主线程休眠，
 * 让调用该方法的线程先执行完毕后在恢复执行主线程
 */
class JoinThread implements Runnable{
    @Override
    public void run() {
            System.out.println("主线程休眠开始...");
            JoinTest.printTime();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程休眠结束...");
            JoinTest.printTime();
    }
}

class JoinThread1 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
        }
    }
}

/**
 * 在主线程中调用子线程的join()方法
 * 主线程会等到子线称执行完才执行结束
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main线程开始...");
        //没有调用join()方法
//        JoinThread1 joinThread1 = new JoinThread1();
//        new Thread(joinThread1,"子线程A").start();
        //调用join方法
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread,"子线程A");
        thread.start();
        thread.join();
        System.out.println("main线程结束...");
    }

    public static void printTime(){
        //获取系统当前时间
        Date date = new Date();
        //为时间设置显示格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间重新转换成字符串
        String str = dateFormat.format(date);
        System.out.println(str);
    }
}

/**
 * main线程开始...
 * main线程结束...
 * 子线程A、0
 * 子线程A、1
 * 子线程A、2
 */