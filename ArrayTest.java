public class ArrayTest{
    
    public static void arrayInit(){
        
        //引用类型
        int[] a = null;
        //a = new int[8]; 
        //NPE .NullPointerException  肯定是一个地方使用null来调用方法、属性
        for(int i=0; i<a.length; i++){
            a[i] = i;
            System.out.println(a[i]);
        }
        String[] s = new String[8];
        for(int i=0; i<8; i++){
            System.out.println(s[i]);
        }
        
        boolean [] b = new boolean[8];
        for(int i=0; i<8; i++){
            System.out.println(b[i]);
        }
    }
    
    
    public static void arrayRef(){
        int [] x = null;
        x = new int[3];
        x[0] = 10;
        x[1] = 20;
        x[2] = 30;
        //x[3] = 40;
        for(int i=0; i<x.length; i++){
            System.out.println(x[i]);
        }
        
        int [] y = x;
        
        for(int i=0; i<y.length; i++){
            System.out.println(y[i]);
        }
        
        x =null;
        for(int i=0; i<y.length; i++){
            System.out.println(y[i]);
        }
        
        //静态初始化
        int [] z = {1,2,3,4,5};
        int [] z2 = new int[]{1,2,3,4,5,6};
        
        for(int i = 0; i< z.length; i++){
            System.out.print(z[i]);
        }
        for(int i = 0; i< z2.length; i++){
            System.out.print(z2[i]);
        }
        
        //匿名数组
        System.out.println(new int[]{1,2,3}.length);
        
    }
    
     public static int[] arrayJoin(int[] a, int[] b ){
        //int[] a  = new int[]{1,2,3,4};
        //int[] b  = new int[]{5,6,7}; 
        //动态初始化
        int[] c = new int[a.length + b.length];
        for(int i=0; i<a.length; i++){
            c[i] = a[i];     
        }
        // {1,2,3,4,0,0,0}
        for(int i= a.length; i<c.length; i++){
            c[i] = b[i-a.length];     
        }
        // {1,2,3,4,5,6,7}
        //for(int i=0; i< c.length ;i++){
        //    System.out.println(c[i]);
        //}
        return c;
    }
    
    public static void twoArray(){
        //动态初始化
        int[][] a = new int[2][3];
        a[0][0] = 1;
        a[1][2] = 6;
        
        //a.length 行
        for(int i=0; i< a.length ; i++){
            //a[i].length 改行的列数
            for(int j=0; j < a[i].length; j++){
                System.out.print(a[i][j] + "\t");   
            }
            System.out.println();
            
        } 

    }
    
    //方法名，参数，返回值
    public static void arrayPrint(int[][] a){
       //a.length 行
        for(int i=0; i< a.length ; i++){
            //a[i].length 改行的列数
            for(int j=0; j < a[i].length; j++){
                System.out.print(a[i][j] + "\t");   
            }
            System.out.println();
            
        }  
    }
    
    public static void arrayExpend(int [] a){
        int [] temp =a;
        for(int i=0; i<temp.length ;i++){
            temp[i] = temp[i]*5;
        }  
    }
    
    public static int[] arrayExpend2(int [] a){
        if(a == null){
            return new int[]{};
        }
        int [] temp = new int[a.length];
        for(int i=0; i<a.length ;i++){
            temp[i] = a[i]*5;
        }  
        return temp;
    }
    
    public static void printArray(int [] a){
        if(a  == null){
            return;
        }
        for(int i=0; i< a.length; i++){
             System.out.print(a[i]+" ");
        }
    }
    
    public static void main(String [] args){
         int [] a = null;
         System.out.print("A before:");
         printArray(a);
         System.out.println();
         int [] res = arrayExpend2(a);
         printArray(res);
         System.out.print("A After:");
         printArray(a);   
    }
    
}