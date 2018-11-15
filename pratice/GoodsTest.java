package www.jin.java11_15;
//商品
class Goods{
    private String goodsName;
    private int count;
    public synchronized void set(String goodsName){
        if(count > 0){
            System.out.println("商品还有库存，等会再忙，先吃个鸡");
            try {
                wait(); //等待消费者消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+goodsName+toString());
        //唤醒等待消费的线程
        notify();
    }

    public synchronized void get(){
        if(count == 0){
            System.out.println("商品买完了，客官等一下");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName()+"消费"+goodsName+toString());
        notify();
    }

    @Override
    public String toString() {
        return "Goods{"+"goodName='"+this.goodsName+'\''+",count='"+count+'\''+"}";
    }
}
//消费者
class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        goods.get();
    }
}
//生产者

class Producer implements Runnable{
    private Goods goods;
    public Producer(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        goods.set("ajlfjalkjfkajfkljakf");
    }
}
public class GoodsTest {
    public static void main(String[] args) throws InterruptedException {
        Goods  goods = new Goods();
        Consumer consumer = new Consumer(goods);
        Producer producer = new Producer(goods);
        new Thread(producer).start();
        Thread.sleep(2000);
        new Thread(consumer).start();

    }
}
