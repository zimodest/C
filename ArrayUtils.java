// Java数组章节练习题
public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
        if(data == null){
            //IllegalArgumentException 参数异常
            throw new IllegalArgumentException("data must be not null.");
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<data.length; i++){
            if(data[i]>max){
                max=data[i];
            }
        }
        return max;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        if(data == null){
            throw new IllegalArgumentException("data must be not null.");
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<data.length; i++){
            if(data[i]<min){
                min=data[i];
            }
        }
        return min;
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        if(data == null){
            throw new IllegalArgumentException("data must be not null.");
        }
        int sum = 0;
        for(int i=0; i<data.length; i++){
            sum=sum+data[i];
        }
        return sum;
    }
    
    //4.数组拼接
    public static int[] arrayJoin(int[] a, int[] b){
        if(a ==null){
            throw new IllegalArgumentException("a must be not null.");
        }
        if(b == null){
            throw new IllegalArgumentException("b must be not null.");
        }    
        int len = a.length+b.length;
        int[] c= new int[len];
        for(int i=0; i<a.length; i++){
            c[i]=a[i];
        }
        for(int i=a.length; i<c.length;i++){
            c[i]=b[i-a.length];
        }
        return c;
    }

    //5.数组截取
    //[start, end)
    public static int[] arraySub(int[] data, int start , int end){
        if(data==null){
           throw new IllegalArgumentException("data must be not null.");
        }
        if(start < 0 || end < 0){
            throw new IllegalArgumentException("start or end  must be > 0.");
        }
        if(end < start){
            throw new IllegalArgumentException("end > start.");
        }
        if(start>=data.length){
            throw new IllegalArgumentException("start must be < data.length .");
        }
        int count = end-start;
        if(count>data.length){
            throw new IllegalArgumentException("sub length must be <= data.length .");
        }
        int[] b = new int[count];
        for(int i=start ; i< end ;i++){
            b[i-start]=data[i];
        }
        return b;
    }
    
    //6.数组打印
    public static void printArray(int[] data){
        if(data == null){
            return;
        }
        for(int i=0; i< data.length; i++){
             System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        for(int i=0; i< data.length/2 ; i++){
              int value = data[i];
              data[i] = data[data.length-1-i];
              data[data.length-1-i] = value;
        }
    }
    
    public static void main(String[] args){
        int[] a = new int[]{23,12,43,51,21,88};
        int max = arrayMaxElement(a);
        System.out.println(max);
        int[] sub = arraySub(a,0,5);
        printArray(sub); 
        printReversal(a);
        printArray(a);
    }
}