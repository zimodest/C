class Person{
    public String name;
    public int age;
    //无参构造
    public Person(){

    }

    //有参构造
    public Person(String name){
        this.name = name;
    }

    public Person(String name,int age){
        this.name= name;
        this.age = age;
    }
    public void eat(){
        System.out.println(name+"吃饭");
    }
    public void sleep(){
        System.out.println(name+"睡觉");
    }
    public void work(){
        if(age < 22){
            System.out.println(name+"老老实实读书");
        }else{
            System.out.println(name+"老老实实搬砖");
        }
    }
}

class Test{
    //int 默认值 0
    //char 默认值 空格
    public int i;
    public char c;
    public Test(){
    }
}

class Print{
    public Print(){
        System.out.println("Hello Constructor");
    }
    public Print(String str){
        System.out.print("Hello Constructor" +" "+str);
    }
}
 
class Pratice {
    public static void main(String args[]){
        Test t= new Test();
        //System.out.println(t.i);
        //System.out.print(t.c);
        // Person a = new Person();
        // a.name="张三";
        // a.age = 18;
        // Person b = new Person();
        // b.name="李四";
        // b.age = 44;
        // a.work();
        // b.work();
        //System.out.println(Fibonacci(6));
        Fibonacci1(6);
        //Print print1 = new Print();
        //Print print2 = new Print("hahahah");
      
    }
    //递归
    public static int Fibonacci(int i){
            if(i<3){
                return 1;
            }
            return Fibonacci(i-1)+Fibonacci(i-2);       
    }
    public static void Fibonacci1(int i){
        int a = 1;
        int b = 1;
        int c ;
        int j;
        
        // for(j=1;j<i;j++){
        //     if(j == 1 || j == 2){
        //         System.out.print(1+" ");
        //         continue;
        //     }
        //     c = a+b;
        //     System.out.print(c+" ");
        //     a = b;
        //     b = c;
        // }
        // System.out.println("");
        j=2;
        while((i-2)>0){
            if(j>0){
                System.out.print(1+" ");
                j--;
                continue;
            }
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
            i--;
        }
    }

    
    //System.out.println(i);

}
//  public static int Fibonacci(int i){
//             if(i<3){
//                 return 1;
//             }
//             return Fibonacci(i-1)+Fibonacci(i-2);
//         }
//没有Static修饰的方法必须放在类中定义
//static修饰的方法中必须使用static修饰方法 

 /** 错误
 * public int Fibonacci(int i){
            if(i<3){
                return 1;
            }
            return Fibonacci(i-1)+Fibonacci(i-2);
        }
 
*/


