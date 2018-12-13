import java.io.IOException;
public class Logic{
    
    public static void triangle(){
        int line = 10;
        for (int x = 0; x < line; x++) { //控制行数
            for (int y = 0; y < line -x ; y++) {    //控制空格
                System.out.print(" ");
           }
           for (int z = 0; z < x ; z++ ) {
                System.out.print("* ");
           }
        System.out.println();
       }
    }
    
    public static void ifMethod(String [] args){
        String pgname = args[0];
        if(pgname.equals("Java")){
            System.out.println("Java is best");
        }else if(pgname.equals("MySQL")){
            System.out.println(" MySQL is best"); 
        }else{
            System.out.println(pgname+ " is not best");
        }
    }
    
    public static void switchMethod()  throws IOException {
        System.out.println("请输入一个字符:");
       char c = (char)System.in.read();
       switch(c){
           case 'a':{
                System.out.println("hello a");
                break;
           }     
           case 'b':{
               System.out.println("hello b");
               break;
           }
                
           default :{
               System.out.println(c);
           }
                
       }
    }
    
    public static void main(String [] args){
      
      //9
      int count =1;
      while(count<10){
          System.out.println(count);
          count++;
      }
    
      
      //1
      do{
          System.out.println(count);
          count--;
      }while(count < 1);
      
      //1
      for(int i =count ; i < 10; i++){
           System.out.println(count);
      }
       
    }
    
    
    
    
}