public class Test7{
    
    public static void main(String[] argss){
        new Son();
    }
    
}

//继承层次不要太深
class GrandFater{
    
    public GrandFater(){
        System.out.println("爷爷");
    }
    
}

class Fater extends GrandFater{
    
   //无参数的构造方法 默认构造方法  public Fater(){}
    public Fater(){
        System.out.println("baba");
    }
}

class Son extends Fater{
    
    //无参数的构造方法 默认构造方法  public Son(){super();}
    public Son(){
        System.out.println("Son");
    }
}