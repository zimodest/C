// public class Test{
//     public static void main(String[] args){

//         //System.out.println("hello world");
//         //System.out.print(10/4);

//         /*
//         int line = 10;
//         for (int x = 0; x < line; x++) { //控制行数
//         for (int y = 0; y < line -x ; y++) {//控制空格
//         System.out.print(" ");
//         }
//         for (int z = 0; z < x ; z++ ) {
//         System.out.print("* ");
//         }
//         System.out.println();
//         }
//             }
//         */
//         //读取字符
//     //    char c = System.in.read();
//         //读取字符串
//     //    Scanner scanner = new Scanner(System.in);
//     //    String str = scanner.nexline();
//     //
//     //int[] x = new int[3];
//     //x[0] = 10;
//     //x[1] = 20;
//     //x[2] = 30;
//     //int [] temp = x;
//     //temp[2]=20;




//    // int[] data = new int[]{1,2,3,4,5,6};
//     //System.out.print(data.length);



//     //System.out.print(new int[]{1,2,3,4,5,6}[0]);

//     int[][] data = new int[][]{{1,2},{3,4,5},{6,7,8,9,10}};

//     for(int x=0;x<data.length;x++){
//         for(int y=0;y<data[x].length;x++){
//             System.out.print(data[x][y]+"");
//         }
//     }
//     }


// }
// class Outter{
//     private String msg="";
//     public void test(){
//         Inner in = new Inner(this);    
//         }   
// }
// class Inner{
//         private String inmsg="";
//         public void fun(){
//             System.out.print();
//         }
//     }

// class C{
//     class InnreClassA extends A{
//         public String name(){
//             return super.getMg;
//         }
//     }
//     class InnreClassB extends B{
//         public int age(){
//             return super.geyAge();
//         }
//     }
//     public String name(){
//         return new InnreClassA().name();
//     }
//     public int age(){
//         return new InnreClassB().age();
//     }
// }

// public class Test{
//     public static void mian(String[] args){
//         Outter out = new Outter();
//         out.test();
//     }
// }



// class Father{
//     private String name = "zhangjun";

//     class Child{
//         public void introFather(){
//             System.out.println(name);
//         }
//     }
// }

// class Test{
//     public static void main(String[] args){
//         Father.Child child = new Father().new Child();
//         child.introFather();
//     }
// }


//非静态内部类不能拥有static变量

// class Test{
//     public static void main(String[] args){
//         shuiXianHua();
//     }
//     public static void shuiXianHua(){
//             for(int i=100; i<1000; i++){
//                 int a = i % 10;
//                 int b = i / 10 % 10;
//                 int c = i / 100;
//                 int d = a*a*a + b*b*b + c*c*c;
//                 if(d == i){
//                     System.out.print(i+ " ");
//                 }
//             }
//         }
// }



/**
5.编程题： 
定义一个抽象的"Role"类，有姓名，年龄，性别等成员变量 
1）要求尽可能隐藏所有变量(能够私有就私有,能够保护就不要公有)， 
再通过GetXXX()和SetXXX()方法对各变量进行读写。具有一个抽象的play()方法， 
该方法不返回任何值，同时至少定义两个构造方法。Role类中要体现出this的几种用法。 
2）从Role类派生出一个"Employee"类，该类具有Role类的所有成员（构造方法除外）， 
并扩展salary成员变量，同时增加一个静态成员变量“职工编号（ID）”。 
同样要有至少两个构造方法，要体现出this和super的几种用法，还要求覆盖play()方法， 
并提供一个final sing()方法。 
3）"Manager"类继承"Employee"类，有一个final成员变量"vehicle" 
在main()方法中制造Manager和Employee对象,并测试这些对象的方法。 

提交作业 
*/
abstract class Role{
    private String name;
    private int age;
    private String sex;
    public Role(){

    }
    public Role(String name){
        this.name = name;
    }
    public Role(String name, String sex){
        this(name);
        this.sex = sex;
    }
    public final void setName(String name){
        this.name = name;
    }
    public final void setAge(int age){
        this.age = age;
    }
    public final void setSex(String sex){
        this.sex = sex;
    }

    public final String getName(){
        return name;
    }
    public final int getAge(){
        return age;
    }
    public final String getSex(){
        return sex;
    }

    abstract void play();
    
}

class Employee extends Role{
    static int ID;
    private int salary;
    public Employee(){
        super();
    }
    public Employee(String name){
        super(name);
    }
    public Employee(String name, String sex){
        super(name, sex);
    }
    public final void setSalary(int salary){
        this.salary = salary;
    }
    public final int getSalary(){
        return salary;
    }
    final void sing(){

    }
    void play(){

    }
}

class Manager extends Employee{
    final String vehicle = "car";
}
public class Test{
    public static void main(String[] args){
        Employee em = new Employee();
        em.setAge(18);
        em.setName("jinshuai");
        em.setSex("");
        System.out.println(em.getAge());
        System.out.println(em.getName());
        System.out.println(em.getSex());
        Manager man = new Manager();
    }
}