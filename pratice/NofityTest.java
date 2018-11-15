package www.jin.java11_15;

class MyThread implements Runnable{
    private Object object;
    private boolean flag;
    public MyThread(Object object, boolean flag){
        this.object = object;
        this.flag = flag;
    }

    public void waitMethod(Object object){
        synchronized (object){
            System.out.println("wait方法开始.."+Thread.currentThread().getName());
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait方法结束.."+Thread.currentThread().getName());

        }
    }
    public void notifyMethod(Object object){
        synchronized (object){
            System.out.println("notify方法开始.."+Thread.currentThread().getName());
            object.notifyAll();
            System.out.println("notify方法结束.."+Thread.currentThread().getName());
        }
    }
    @Override
    public void run() {
        if(this.flag == true){
            this.waitMethod(this.object);
        }else if(this.flag == false){
            this.notifyMethod(this.object);
        }
    }
}
public class NofityTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        //MyThread myThread = new MyThread(object,true);
        for(int i = 0;i<10;i++){
            MyThread myThreadi = new MyThread(object,true);
            new Thread(myThreadi,"线程"+i).start();
        }
        MyThread myThread = new MyThread(object,false);
        new Thread(myThread,"线程A").start();

    }

}
