//Tectonic block / construction method /static block execution order 

class A{
    public A(){
        System.out.println("1.A方法的构造方法");
    }
    {
        System.out.println("2.A方法的构造块");
    }
    static {
        System.out.println("3.A方法的静态块");
    }
}

//Loading parent class before loading Subclass class 
//Static blocks take precedence over Tectonic block
//Static blocks are executed when classes are loaded.
//Building blocks are executed when objects are generated 
//    and take precedence over construction methods

public class B extends A{
    public B(){
        System.out.println("4.B方法的构造方法");
    }
    {
        System.out.println("5.B方法的构造块");
    }
    static {
        System.out.println("6.B方法的静态块");
    }
    public static void main(String[] args){
        System.out.println("7.start-----------");
        new B();
        new B();
        System.out.println("8.end-------------");
    }
}