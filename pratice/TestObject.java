public class TestObject{
    
    public static void fun(Object obj){
        System.out.println(obj);//obj.toString();
    }

    public static void code1(){
        Person person = new Person();
        
        person.setName("Jack");
        person.setAge(18);
        
        Student student =new Student();
        Person person1 = student;//ok ,ok
        Object obj1 = person;//ok,ok
        Object obj2 = student;//ok,ok
        fun(person);//1
        fun(student);//2
        fun(person1);//3
        fun(obj1);//4
        fun(obj2);//5
    }
    
    
    public static void code2(){
        Person person1 = new Person();
        person1.setName("jack");
        person1.setAge(18);
        
        Person person2 = new Person();
        person2.setName("tom");
        person2.setAge(19);
        
        Person person3 = person1;
        
        Person person4 = new Person();
        person4.setName("jack");
        person4.setAge(18);
   
        System.out.println(person1 == person2);//false
        System.out.println(person1 == person3);//true
        
        System.out.println(person1.equals(person2));//false
        System.out.println(person1.equals(person3));//true
         System.out.println(person1.equals(person4));//true
    }
    
    
    public static void code3(){
         //Object 能够接受Java所有类型的对象（类，接口，数组）
        Object obj1 =  new int[]{1,2,3,4};
        int[] intArray = (int[])obj1;
        
        //增强的for循环，foreach
        for(int value : intArray){
            System.out.print(value+ " , " );
        }
        
        //Object接受接口类型
        //向上转型
        Object obj2  = new IMessage(){
            
            public void print(){
                System.out.println("java is best");
            }
        };
        //向下转型
        IMessage imessage = (IMessage)obj2;
        imessage.print();
        
        //Object obj3 = 10;//ok , ok ? 基本数据类型 为何能够转型到引用类型 包装类型的内容
        
        //包装  -> 装箱
        Object obj3 = new IntWrapper(10);
        IntWrapper intWrapper = (IntWrapper)obj3;
        //打开包装 -> 拆箱
        int intValue = intWrapper.getValue();
        
        //String str1 = 10;//error
        //Person p = 10;//error
    }
    
    
    public static void code4(){
        Integer intObj =  new Integer(10); //10->装箱->intObj
       int intValue = intObj.intValue(); //intObj ->拆箱-> 10
       System.out.println(intValue);
        
       //JDK 自动 装箱 ，拆箱
       //1. 包装类
       //2. 自动装箱，拆箱
       Object obj3 = 10;
       int value = (int)obj3;
       
       Number number1= 10;
       Object obj4 = false;
       
       
       // 自动装箱
       Integer x = 55 ; //new Integer(55)
       // 可以直接利用包装类对象操作
       //x.intValue();
       System.out.println(++x * 5 );
    }
    
    
    public static void code5(){
        //基本数据类型 ，包装类型（引用数据类型）
        
        //基于String赋值的方式-->内存池
        
        //包装Integer直接跟内存有关，而是Integer内部做了缓存
        //[-128 , 127]
        Integer a = 100; //-> Integer.valueOf(a);
        Integer b = 100;
        //IntegerCache
        Integer j = Integer.valueOf(127);
        Integer k = Integer.valueOf(127);
        
        Integer c = new Integer(100);
        Integer d = new Integer(100);
        Integer e = new Integer(666);
        Integer f = new Integer(666);
        
        Integer g = 666; //new Integer(g);
        Integer h = 666;

        System.out.println(a == b); //true
        System.out.println(a.equals(b)); //true
        
        System.out.println(g == h); //true
        System.out.println(g.equals(h)); //true
        
        
        System.out.println(a == c);//false
        System.out.println(a.equals(c));//true
        
        System.out.println(c == d);//false
        System.out.println(c.equals(d));//true
        
        System.out.println(e == f);//false
        System.out.println(e.equals(f));//true
    }
    
    
    public static void code6(){
        String str1 = "123";
        //默认是10进制
        int int1 = Integer.parseInt(str1);
        //radix : 当前转换的字符表示的数字的进制
        int int2 = Integer.parseInt(str1, 16);
        //java数字表示的进制默认10进制
        System.out.println(int1);
        System.out.println(int2);
        
        String str2 = "123.41";
        double double1 = Double.parseDouble(str2);
        System.out.println(double1);
        
        //boolean  true false
        //str  true 的字符串即可，并且是忽略大小写，返回true 否则false
        System.out.println(Boolean.parseBoolean("true"));//true
        System.out.println(Boolean.parseBoolean("True"));//true
        System.out.println(Boolean.parseBoolean("TRUE"));//true
        System.out.println(Boolean.parseBoolean("false"));//false
        System.out.println(Boolean.parseBoolean("abc"));//false
       
        System.out.println("===============");
       
        //基本数据类型转字符串 String
        String intStr = String.valueOf(1);
        String doubleStr = String.valueOf(123.14);
        String booleanStr = String.valueOf(true);//false
        System.out.println(intStr);
        System.out.println(doubleStr);
        System.out.println(booleanStr);
        
        //JDK7
        int a  = 100_000;
        int b  = 0b0110; //6 二进制表示方式
        System.out.println(a+b);
        
    }
    
    
    //Java语言中参数传递：值传递 (栈空间的内容)
    //基本数据类型-> 栈空间 -> 值
    //引用数据类型变量 -> 栈空间 -> 引用的对象所在的堆空间的地址
    public static void swap(int args1, char[] args2){
        args1  = 10;
        //chars --> 
        char[] chars = args2;//1
        chars[0] = 'A';
        args2 = new char[]{'C','D'};//2
    }
    
    public static void main(String[] args){
        int a  =20;
        char[] ch = new char[]{'a','b'};//1
        
        swap(a, ch);
        
        System.out.println(a); //20 
        System.out.println(java.util.Arrays.toString(ch));// a,b ; A,b 
       
       
    }
    
    
}

//10 -> 引用类型
class IntWrapper{
    
    private final int value;
    
    public IntWrapper(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
    
    @Override
    public String toString(){
        return this.value+"";
    }
}


interface IMessage{
    
    void print();
    
}


class Person{
    
    private String name;
    private int age;
    
    public void setName(String name){
        this.name= name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    
    @Override
    public boolean equals(Object obj){
         if(obj == null){
             return false;
         }
         //this obj 是同一个对象（地址）
         if(this == obj){
             return true;
         }
         //this obj 不是同一个对象(内容)
         //name,age 
         if(obj instanceof Person){
             Person that = (Person)obj;
             //比较内容注意确定比较属性
             return this.getName().equals(that.getName()) && this.getAge() == that.getAge();
         }
         return false; 
    }

    //覆写方法添加@Override注解
    @Override
    public String toString(){
        //大量拼接字符串-> StringBuffer ,StringBuilder
        return "Name:"+this.getName()+" Age:"+this.getAge();
    }
}


class Student extends Person{
    
}