package www.bit.java.util;

/**
 * @author yuisama
 * @date 2018/11/10 13:46
 */
public class Test {
    public static void main(String[] args) {
        // 总共10个人
        int total = 10;
        int[] people = new int[total];
        // 给每个人编号
        for (int i = 0;i < 10; i++) {
            people[i] = i+1;
        }
        // 从0开始报数
        int flag = 0;
        int i = 0;
        int quitPeople = 0;
        int n = total-1;
        while (quitPeople < n) {
            if (people[i] != 0) {
                flag++;
            }
            if (flag == 3) {
                people[i] = 0;
                quitPeople ++;
                flag = 0;
            }
            i++;
            if (i == total) {
                i = 0;
            }
        }
        for(int j = 0;j < 10; j++) {
            if (people[j] != 0) {
                System.out.println(j);
            }
        }
    }
}

可重入锁:
package www.bit.java;

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

public class Test{
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        Thread threadA = new Thread(mt,"A");
        Thread threadB = new Thread(mt,"B");
        threadA.start();
        Thread.sleep(200);
        threadB.start();
    }
}

/**
 * 给定一个英文字符串，
 * 写一段代码找出字符串中首先出现三次的英文字母。 输入描述：输入数据一个
 * 字符串，包括字母，数字 输出描述：输出首先出现三次的那个英文字符
 * 示例： 输入： Have you ever gone shopping
 * and 输出： e
 */
public class Test{
    public static void main(String[] args) {
        String str = "111Have  you ever gon shopping";
        System.out.println(firstThree(str));
    }
    public static char firstThree(String str) {
        // string->char[]
        char[] data = str.toCharArray();
        int[] hash = new int[256];
        for (int i = 0;i < data.length;i++) {
            // hash
            char c = data[i];
            if ((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                hash[c] ++;
                if (hash[c] == 3) {
                    return c;
                }
            }
        }
        return '0';
    }
}