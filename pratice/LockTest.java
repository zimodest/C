package www.jin.TongBu;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyLock implements Runnable{
    private Lock lock = new ReentrantLock();
    private int ticket = 500;
    @Override
    public void run() {
        for(int i = 0; i<500;i++){
            try {
                lock.lock();
                Thread.sleep(20);
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"还剩下"+this.ticket--+"票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        MyLock ml = new MyLock();
        Thread threadA = new Thread(ml,"黄牛A");
        Thread threadB = new Thread(ml,"黄牛B");
        Thread threadC = new Thread(ml,"黄牛C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
