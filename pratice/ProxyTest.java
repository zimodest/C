public class ProxyTest{

    
    public static void code1(){
        RealSubject realSubject =new RealSubject();
        
        ProxySubject proxySubject = new ProxySubject(realSubject);
        
        proxySubject.buyComputer();
        
        //代理设计模式的专业名词
        //Subject  代理接口
        //RealSubject 业务类
        //ProxySubject 代理类
        //new RealSubject()  目标对象,被代理对象
        //new ProxySubject(subject) 代理对象
    }

    public static void main(String[] args){
        
        Print print = new Println();
        
        Print proxPrint = new ProxyPrintln(print);
        
        proxPrint.println("hello");
        
       
        
    }

}

//代理模式
interface Subject{
    
    void buyComputer();
    
}

//真正业务
class RealSubject implements Subject{
    
    public void buyComputer(){
        System.out.println("购买一台外星人的笔记本");
    }
}

//代理类-辅助我们真正的业务类
class ProxySubject implements Subject{
    
     private final Subject target;
     
     public ProxySubject(Subject target){
         this.target = target;
     }     
    
     public void buyComputer(){
        System.out.println("生产外星人的笔记本");
        this.target.buyComputer();//正在的业务逻辑
        System.out.println("外星人笔记本的售后团队正式为你服务");
    }
}


//案例
interface Print{
    void println(Object o);
}

class Println implements Print{
    public void println(Object o){
        System.out.println(o);
    }
}

class ProxyPrintln implements Print{
    
    //接口类型
    private final Print target;
    
    public ProxyPrintln(Print target){
        this.target = target;
    }
    
    public void println(Object o){
        this.target.println(o);
        System.out.println("。");
    }
}









