package www.NiuKe.TI_11_23;

import java.util.concurrent.ThreadPoolExecutor;

public class ForTest {
    static boolean foo(char c){
        System.out.print(c);
        return true;
    }
    public static void main(String[] args) {
        int i = 0;
        for(foo('A'); foo('B') && i<2; foo('C')){
            foo('D');
            i++;


        }
    }
}
/**
 * what is the result?  A
 * A:ABDCBDCB
 * B:ABCDABCD
 * C:Complilation fails
 * D:An exception is thrown at runtime
 *
 * 解析
 * for(条件1;条件2;条件3)
 * {
 *     语句
 * }
 *
 * 执行顺序是条件1-->条件2-->语句-->条件3-->条件2-->语句-->条件3-->条件2
 * 如果条件2为true，则一直执行，如果条件2为false，则for循环结束
 */
