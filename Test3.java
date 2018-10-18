public class Test3{
    static class Test{
        public Test(){
            System.out.println("内部类的构造方法");
        }
        {
            System.out.println("内部类的构造块");
        }
        static {
            System.out.println("内部类的静态块");
        }
    }
    static{
        System.out.println("主类中的静态块");
    }
    public static void main(String[] args){
        System.out.println("5.start----------");
        new Test();
        new Test();
        System.out.println("6.end------------");
    }
}