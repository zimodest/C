public class Test6{
    
    public static void main(String[] argss){
        Student student = new Student("jack","男","1","bit");
        System.out.println(student); //toString();
    }
    
}
//学生  学号 学校
//Person是Student的父类
//Student是Person的子类
//Java单继承
class Student extends Person{

    private String num;
    
    private String school;
    
    public Student(String name, String gender, String num, String school){
        //直接赋值  --> 能够访问到父类的属性
        //通过构造方法 --> 父类提供构造方法/带参数
        //通过setter方法 --> 能够访问到父类的setter方法 
        super(name,gender);//super(); 
        this.num = num;
        this.school = school;
        System.out.println("这是Student子类的构造方法");
    }
    
    
    public String getNum(){
        return this.num;
    }
    
    public String getSchool(){
        return this.school;
    }
    
    /*
    public String toString(){
         return  " 姓名："+this.getName()+" 性别:"+this.getGender()
         + " 学号："+this.getNum() +" 学校："+this.getSchool();
    }
    */
     //方法覆写
     @Override
     public String toString(){
         return  super.toString() 
         + " 学号："+this.getNum() +" 学校："+this.getSchool();
    }
}

//面向对象的一个特性 封装  扩展  开闭原则 
class Person{
    //姓名
    private String name;
    //性别
    private String gender;
    
    public Person(String name, String gender){
        this.name= name; 
        this.gender = gender;
        System.out.println("这是Person父类的构造方法");
    }
  
    //getter 方法
    public String getGender(){
        return this.gender;
    }
    
    public String getName(){
        return this.name;
    }

    
    public String toString(){
        return  " 姓名："+this.name+" 性别:"+this.gender;
    }
}