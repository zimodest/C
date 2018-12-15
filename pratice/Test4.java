public class Test4{
    
    public static void main(String [] args){
        Outer outer = new Outer();
        
        outer.display(15);
    }
    
}

interface MyInterface{
    
    void test(); //public abstract void test();

}

class Outer{
    
    private int num =20;
    
    //final int value
    public void display(int value){
        
       //匿名内部类  实现了一个接口 MyInterface
       //匿名类 没办法创建更多的对象 只能有一个( 匿名对象, 有名字的对象）
       MyInterface my =  new MyInterface() {
                
               public void test(){
                    
                    //来自Outer的成员方法的参数 value 
                    System.out.println("Value = "+ value); //
                    //来自Outer的成员属性
                    System.out.println("num = "+num); //20
                   
                }
  
       }.test();
          
       // 线程 ， lambda表达式 ， 函数接口， Stream流
          
    }
}




