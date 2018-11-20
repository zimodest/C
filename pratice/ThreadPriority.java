package day23.code.day23_Thread.src.cn.itcast_03;

public class ThreadPriority extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x);
        }
    }
}