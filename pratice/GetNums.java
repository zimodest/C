package www.jin.java11_7;

public class GetNums {
    public static void main(String[] args){
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        getNums(arr);
    }

    public static void getNums(int[] arr){
        int i, j, k;
        int m;
        for(i = 0; i<arr.length;i++){
            for(j=i+1;j<arr.length;j++){
                for(k=j+1;k<arr.length;k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if(0 == sum){
                        System.out.print("["+arr[i]+","
                                +arr[j]+","+arr[k]+"]");
                    }
                }
            }
        }
    }
}
