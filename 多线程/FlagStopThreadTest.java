package www.multithreading;


/**
 * 停止线程的方法
 * 1、设置标志位停止线程（推荐使用）
 * 2、调用stop()方法强制停止线程（不安全）不要使用
 * 3、调用Thread类的interrupt()方法
 */


/**
 * stop 强制停止线程会造成垃圾数据
 * ；while(){
 *     x = 3;
 * ------ stop  -----
 *     y = 4;
 * }
 * stop停止后y无法赋值，会造成垃圾数据
 */
class FlagStopThread implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while(flag){
            System.out.println(Thread.currentThread().getName()
                    +"第"+i+"次执行....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}

public class FlagStopThreadTest {
    public static void main(String[] args) throws InterruptedException {
        FlagStopThread flagStopThread = new FlagStopThread();
        Thread thread = new Thread(flagStopThread,"子线程A");
        thread.start();
        //主线程等待5秒
        Thread.sleep(5000);
        //1、设置标志位停止线程
        //flagStopThread.setFlag(false);
        //2、调用stop方法停止线程
        thread.stop();
    }
}
