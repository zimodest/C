package www.jin.TongBu;

//可重入锁
class MyThread implements Runnable {
    @Override
    public void run() {
        testA();
        testB();
    }
    // 线程A
    public synchronized void testA() {
        // 线程A持有MyThread 对象mt 的Monitor ，值为1
        if (Thread.currentThread().getName().equals("A")) {
            testB();
            while (true) {
            }
        }
    }
    // 线程B
    public synchronized void testB() {
        if (Thread.currentThread().getName().equals("B")) {
            System.out.println("B线程输出..");
        }
        else {
            System.out.println(Thread.currentThread().getName()+"线程输出..");
        }
    }
}


public class MySyncTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        Thread threadA = new Thread(mt,"A");
        Thread threadB = new Thread(mt,"B");
        threadA.start();
        Thread.sleep(200);
        threadB.start();

    }
}
