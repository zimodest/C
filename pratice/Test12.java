public class Test12{
    
    public static void showA(A a){
        System.out.println(a.getInfo());
    }
    
    
    public static void test() {
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7=9;
        b3=(byte)(b1+b2);  /*语句1*/ //ok
        b6=b4+b5;    /*语句2*/ //ok
        b8=(byte)(b1+b4);  /*语句3*/ //ok
        //b7=(b2+b5);  /*语句4*/ //error
        
        //final byte b11  =10;
        //byte b12 =b11;   //ok
        
        System.out.println(b3+b6);
    }
    
    public static void main(String[] args){
          /*
          showA(new A());
          showA(new A1());//向上转型
          showA(new A2()); 
          showA(new A3()); */
          test();
    }
}

class A{

   String getInfo(){
       return "A";
   }
    
}

class A1 extends A{
    String getInfo(){
       return "A1";
   }
}

class A2 extends A{
    String getInfo(){
       return "A2";
   }
}


class A3 extends A{
    String getInfo(){
       return "A3";
   }
}