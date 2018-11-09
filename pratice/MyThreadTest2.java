package www.jin.java11_7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现有返回值的线程必须实现Callable<V>
 */
class MyThread3 implements Callable<String> {
    private int ticket = 10;
    @Override
    public String call() throws Exception {
        while(ticket>0){
            System.out.println("剩余票数"+this.ticket--);
        }
        return "票完了，下次吧.....";
    }
}
public class MyThreadTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> task = new FutureTask<>(new MyThread3()) ;
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
    }
}
