public class Chenge {
    
    public static void Exchenge(int a,int b){
           //算数运算
           a = a + b;
           b = a - b;
           a = a - b;   
    }
    
    public static void change(char[] ch){
        ch[0]='a';
    }
    
    public static void main(String []args){
    
      char[] ch = new char[]{'b','c'};
      change(ch);
      for(int i=0; i<ch.length; i++){
          System.out.println(ch[i]); //b c   //  a  c 
      }
      
      
      
      
    }
}