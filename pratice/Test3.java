public class Test3{
 
    public static void main(String[] args){
       // Outer3 outer = new Outer3();
       // System.out.println(outer.getName());
       // System.out.println(outer.getAge());        
       // InnerA;
        
        //非静态内部类要在其它地方使用的时候，创建对象的方式
        //InnerA 成员内部类 ， 非静态内部类
        //InnerA 对象内部 引用了一个外部类对象的引用
           //静态内部类 创建 不依赖外部类对象
        //静态内部类的类名 外部类.静态内部类 
        //Outer.InnerC innerC =  new Outer.InnerC();
        //System.out.println(innerC.getNum());
        
        Outer outer = new Outer();        
        System.out.println("=========");
        outer.display(18);
        
    }

}


class A{
    private String name ="A 属性";
    
    public String getName(){
        return this.name;
    }
} 

class B extends A {
    private int age  = 20;
    
    public int getAge(){
        return this.age;
    }
}

class Outer{
    
    private int num  = 20 ;
    
    class InnerA extends A{
          
        public String name(){
            return super.getName(); //前对象   getName(); this super
        }
        //父类方法重写
        
        public int getNum(){
            System.out.println("原始值："+Outer.this.num);
            
            Outer.this.num = 22;
            System.out.println("Outer this "+Outer.this);
            return Outer.this.num;
        }
    }
    
    class InnerB extends B{
        public int age(){
            return this.getAge();
        }
    }
    
    public static class InnerC {
        
        //静态内部类 不能 访问外部内的非静态属性和方法
        public int getNum(){
            //return num; //error
            return 33;
        }
    }
   //外部类访问内部类的方法或者属性，通过创建内部类的实例化对象或者必须持有内部类的实例化对象的引用
    public String getName(){
        return new InnerA().name();
    }
    
    public int getAge(){
        return new InnerB().age();
    }

    //JDK8  public void display(final int test)
    public void display(int test){
        //参数，变量 这时候不管你是否给变量添加final修饰符，编译器自动添加
        final int a =40 ;
        class Inner {
            
            public void fun(){
                num ++;
                System.out.println(test);
                System.out.println(num);
                System.out.println(a);  
            }
            
        }
 
        new Inner().fun();
        //test = 21;
        //a =41;
    }
    
}

//Java单继承
class Outer3 extends B  {
      
}


