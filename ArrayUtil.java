import java.util.Arrays;
public class ArrayUtil{
    
     public static void printArray(int [] a){
        if(a  == null){
            return;
        }
        for(int i=0; i< a.length; i++){
             System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    public static void printArray(char [] a){
        if(a  == null){
            return;
        }
        for(int i=0; i< a.length; i++){
             System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    public static void javaSupportMethod(){
        int[] src  = new int[]{1,2,3,4,5,6,7,8};
        //int[] dest = new int[3];
        
        printArray(src);
        //printArray(dest);
    
        //
        //System.arraycopy(src,2,dest,0,3); 
        int[] dest = Arrays.copyOf(src,10);
        printArray(src);
        printArray(dest);
    }
    
    /**
    *
    * int[] array max length = 4 
    * int[0] ：最大值
    * int[1] : 最小值
    * int[2] ：平均值
    * int[3] ：总和
    */
    public static int[] computeStatics(int [] data){
        
         //最大值
        //最小值
        //平均值
        //总和
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int avg = 0;
        int sum = 0;
        
        if(data == null){
            return new int[]{max,min,avg,sum};
        }
        
        for(int i=0; i< data.length ; i++){
            //最大值
            if(data[i]>max){
                max = data[i];
            }
            
            //最小值
            if(data[i]<min){
                min= data[i];
            }
            
            //总和
            sum = sum+data[i];
 
        }
        //平均值
        avg = sum / data.length;
        return new int[]{max,min,avg,sum};
    }
    
    
    public static void main(String[] args){
        
        int[] data = new int[]{11,23,44,32,87};
        int[] result= computeStatics(data);
        System.out.println("最大值:"+result[0]);
        System.out.println("最小值:"+result[1]);
        System.out.println("平均值:"+result[2]);
        System.out.println("总和:"+result[3]);
          
       
    }
    
}