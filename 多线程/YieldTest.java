package www.multithreading;

/**
 * 线程让步yield()
 *running -> runnable,不会释放锁
 * 不一定会立马交出CPU
 * ruunable -> ruuning
 *
 *
 * 运行结果
 * A 或者 B 或者 C 有可能会连续输出
 * 将循环连续执行完
 * A、0 。。一个线程连续执行
 * A、1 。。
 * A、2 。。
 * B、0
 * C、0
 * B、1
 * C、1
 * B、2
 * C、2
 */
class YieldThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
            Thread.yield();
        }
    }
}

public class YieldTest {
    public static void main(String[] args) {
        YieldThread yieldThread = new YieldThread();
        Thread thread1 = new Thread(yieldThread,"A");
        Thread thread2 = new Thread(yieldThread,"B");
        Thread thread3 = new Thread(yieldThread,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
