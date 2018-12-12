public class Factorial{
    
    //数据类型预估 
     public static long computeFac(long i){
        if (i==1L){
            return 1L;
        }else{
            return i * computeFac(i-1) ;
        }
     }
     
    public static void main(String [] args){
        long ret = computeFac(60);
        //BigDecimal
        System.out.println(ret);
    }
}