package www.multithreading;


/**
 * 线程休眠sleep（long time) ruuning -> blocked, 不会释放锁
 * 立马交出
 * 休眠时间结束后 blocked -> ruunable
 *
 *
 * 证明sleep立马交出CPU
 */

class SleepThread implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 如果不直接交出CPU
 * 有可能出现A 或者 B 或者 C 连续出现两次
 */
public class SleepTest {
    public static void main(String[] args) {
        SleepThread sleepTest = new SleepThread();
        Thread thread1 = new Thread(sleepTest,"A");
        Thread thread2 = new Thread(sleepTest,"B");
        Thread thread3 = new Thread(sleepTest,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/**
 * Sleep执行结果
 * A、0
 * B、0
 * C、0
 * A、1
 * B、1
 * C、1
 * A、2
 * B、2
 * C、2
 */

/**
 * yield执行结果
 * A、0 。。连续执行
 * A、1 。。
 * A、2 。。
 * B、0
 * C、0
 * B、1
 * C、1
 * B、2
 * C、2
 */
