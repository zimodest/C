public class Test1{
   
    public static void main(String [] args){
        //long x = 1L ;
        System.out.println(11+1l);
        
        //小类型 到 大类型
        //大类型 到 小类型  强转(int)
        long num = 2147483648L;
        int result = (int)num; 
        System.out.println(result);
    }
}