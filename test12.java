public class Test2{
    
     public static void main(String[] args){
        Inner2 inner2 =new Inner2();
        Outer2 outer2 = new Outer2(inner2);
        outer2.fun();    

        new Inner(); //隐藏
           
    }
    
}
//普通类
class Outer2 {
    
    private String msg = "this is a atrribute";
    
    private Inner2 inner2;
    
    public Outer2(Inner2 inner2){
        this.inner2 = inner2;
    }
    
    public void fun(){
        inner2.print();//Inner2的方法
    }
}

//普通类
class Inner2 {

    private String msg  = "this is a inner attribute";
    
    public void print(){
        System.out.println("这是个从Inner的方法中输出的："+ 
        this.msg);
    }

}