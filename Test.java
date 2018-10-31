interface Computer{
    int computer(int m, int n);
}

class AddComputerImpl implements Computer{
    public int computer(int m, int n){
        return m+n;
    }
}

class SumComputerImpl implements Computer{
    public int computer(int m, int n){
        return m-n;
    }
}

class MulComputerImpl implements Computer{
    public int computer(int m, int n){
        return m * n;
    }
}

class DivComputerImpl implements Computer{
    if(m == 0)
        return 0;
    public int computer(int m, int n){
        return m / n;
    }
}

class UseCompute{
    public void useCom(Computer com, int one, int two){
        System.out.println(com.computer(one, two));
    }
}


public class Test{
    public static void main(String[] args){
        UseCompute use =  new UseCompute();
        use.useCom(new AddComputerImpl(),2,3);
    }
}



// interface InterfaceA{
//     System.out.println("interface");
//     String S = "good";
//     void f();
// }

// abstract class ClassA{
//     System.out.println("CA");
//     abstract void g();
// }

// class ClassB extends ClassA implements InterfaceA{
//     void g(){
//         System.out.print(S);
//     }
// System.out.println("classz");
//     public void f(){
//         System.out.print(""+S);
//     }
//     System.out.println("class2");
// }

// public class Test{
//     public static void main(String[] args){
//         ClassA a = new ClassB();
//         InterfaceA b = new ClassB();
//         a.g();
//         b.f();
//     } 




    // public static void main(String[] args){
    //     int[] nums = new int[]{11, 3, 2, 7,8};
    //     Test test = new Test();
    //     int target = 9;
    //     System.out.println("["+test.twoSum(nums,9)[0]+","+test.twoSum(nums, 9)[1]+"]");
    // }
    // public int[] twoSum (int[] nums, int target){
    //     int[] arr = new int[2];
    //     for(int i = 0;i < nums.length; i++){
    //         for(int j =i; j < nums.length; j++){
    //             if(target == nums[i] + nums[j]){
    //                 arr[0] = i;
    //                 arr[1] = j;
    //             }

    //         }
    //     }
    //     return arr;
    // }
//}



















// class A{
//     {
//         System.out.println("1.非主类的构造块");
//     }
//     static {
//         System.out.println("2.非主类的静态块");
//     }
// }
// public class Test{
//     public static void main(String[] args) {
//         new A();
//         new A();
//         new A();
//     }
//  }

// //---------------------------------------------------------------------------
// public class Test{
//     static {
//         System.out.println("1.主类的静态块");
//     }
//     public static void main(String[] args) {
//         System.out.println("2.主方法");
//     }
//  }
 //输出结果：
 //1.主类的静态块
 //2.主方法
//-----------------------------------------------------------------------------






//  public class Test{
//     //构造块
//     {
//         System.out.println("构造块");
//     }
//     public static void main(String[] args) {
        
//     }
//  }
//-----------------------------------------------------------------------------

// class Fu {
// public Fu(String name) {
// System.out.println("hello");
// }
// }
// class Zi extends Fu {
// public Zi(String name) {
// //子类调用父类的有参构造时，必须用super(name)调用
// //调用无参构造时，super()可写可不写
// super(name); //必须是第一行
// System.out.println("world");
// }
// }

// public class Test{
//     public static void main(String[] args) {
//         Zi z2 = new Zi("java");
//     }
// }


//-----------------------------------------------------------------------------
// public class Test{
//     int a;
//     //调用类的属性和方法，必须通过对象使用，否则会报错：
//     //无法从静态上下文中引用非静态
//     public static void main(String[] args){
//         System.out.println(new Test().a); //输出:0
//     }
// }


//-----------------------------------------------------------------------------
// public class Test{
//     public static void main(String[] args){
//         //Java虚拟机内存和栈
//         int a;//错误: 可能尚未初始化变量a
//         System.out.println(a);
//     }
// }
//-----------------------------------------------------------------------------
// public class Test{
//     public static void main(String[] args){
//         //java默认整形常量是int型
//         byte b = 120; //编译正常
//         //----------
//         //错误: 不兼容的类型: 从int转换到byte可能会有损失
//         int a = 120; 
//         byte c = a;
//     }
// }
//-----------------------------------------------------------------------------
// public class Test{
//     public static void main(String[] args){
//         //保存当前int最大值
//         int MaxValue = Integer.MAX_VALUE;
//         //保存当前int的最小值
//         int MinValue = Integer.MIN_VALUE;

//         //数据溢出
//         System.out.println(MaxValue + 1); //-2147483648（最小值）
//         System.out.println(MinValue - 1); //2147483647（最大值）
//     }
//  }

// public class Test{
//     public static void main(String[] args){
//         //保存当前int最大值
//         //用较大的数据类型保存int的最大值加1，为何还是数据溢出？
//         //程序从右向左执行，Integer.MAX_VALUE 和 1都是int型，相加之后还是int型
//         //而MaxValue保存的是溢出的值，所以，输出还是和溢出的值相等
//         long MaxValue = Integer.MAX_VALUE + 1;
//         long MinValue = Integer.MIN_VALUE - 1;
//         System.out.println(MaxValue); //-2147483648
//         System.out.println(MinValue); //2147483647
//     }
//  }

// public class Test{
//     public static void main(String[] args){
//         //保存当前int最大值
//         //解决上述代码问题的方法
//         //在赋值之前要将计算结果转换成long型
   
//         //在Java中小的数据类型和大的数据类型做数值运算时，
//         long MaxValue = Integer.MAX_VALUE + 1L;
//         //小的数据类型会自动提升为大的数据类型

//         //直接对其进行强转，转换成long型
//         long MinValue = (long)Integer.MIN_VALUE - 1;

//         //正常的输出
//         System.out.println(MaxValue); //2147483648
//         System.out.println(MinValue); //-2147483648
//     }
//  }
//-------------------------------------------------------------------------

// //java中方法和变量必须放在类中
// /**
// 主类名必须与文件名相同 */
// //public class Test(主类) 
// //public 申明的类只能是主类，且只有一个
// public class Test{
//     public static void main(String[] args){
//     }
// }
// //没有public修饰的类可以有多个
// class A{}