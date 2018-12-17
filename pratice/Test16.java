public class Test16{

    public static void main(String[] args){
        IMessage imessage = new QQMessage();        
        Platform platform = new QQMessage();
        QQMessage qqmessage = new QQMessage();
        
        //类型之间转换：编译阶段，运行阶段
        //Platform platform =(Platform)imessage; //编译就可以通过
        //System.out.println(imessage instanceof Platform);
    
        //Company company =  qqmessage; //编译，运行ok
        //company.printCompany();
        
        /*
        Company company = (Company)platform; //
        company.print();
        company.printCompany();
        */
        
        //MsnMessage msnmessage= new MsnMessage();
        //Platform platform1 = msnmessage;//ok ok 
        //Company company = (Company)platform1;//ok , error CCE
        
        //接口继承接口
        Combination qqcombination = new QQMessage(); //ok, ok
        qqcombination.print();
        qqcombination.supportPlatform();
        
        IMessage imessage1 = qqcombination; //ok , ok
        Platform platform1 = qqcombination; //ok, ok
        Platform platform2 = (Platform)imessage1 ;//ok,ok
        
        //内部静态接口
        System.out.println("---------------------");
        
        C c = new C();
        c.print();
        
        A.B b = new C();
        b.print();
        
        A.B d = c; 
        d.print();
        
    }
}

//1.接口的实现类，要实现接口的抽象方法
//2.接口中定义的方法，默认就是public
//3.接口中定义的变量，实际就是全局常量，默认是public static final
//3.子类可以实现多个接口, 子类的实例化对象可以向上转型成任意接口类型
//4.子类可以继承抽象类（类）, 先extends 再implements
//5.抽象类可以实现接口（多个），接口的方法抽象类可以选择实现，如果抽象类不实现它所实现的接口中抽象方法，则抽象类的子类就必须实现接口中方法
//6.接口不能继承抽象类（类），可以继承接口并且是多继承
class QQMessage implements Combination{
 
   
    public void print(){
        System.out.println("这是QQMessage");
    }

    public void supportPlatform(){
        System.out.println("QQ支持 windows和Macos平台");
    }
    
    /*
    public void printCompany(){
        System.out.println("Tencent 出品");
    }*/
}

class MsnMessage implements IMessage, Platform{
     
    public void print(){
         System.out.println("这是MsnMessage");
    }
    
    public void supportPlatform(){
        System.out.println("MSN支持 windows");
    }
}

//抽象类
abstract class Company implements IMessage, Platform{
    
   public abstract void printCompany();
   
   public void print(){
       System.out.println("这是Company实现的print方法");
   }
}


interface A {
    
    void print();
    
    //内部接口
    static interface B{
        void print();
    }
}

class C implements A.B{
     public void print(){
         System.out.println("这是接口A的内部静态接口B的方法，由C类实现");
     }
}





