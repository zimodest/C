class InsertSort1{
    public static void main(String[] args){
        int[] array = new int[]{3,6,5,7,9,2,8};
        InsertSort1(array,array.length);
        for(int i=0; i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void InsertSort1(int array[], int size){
        int key;
        int i;
        int j;
        for(i=0;i<size;i++){
            key = array[i];
            for(j=i-1;j>=0;j--){
                if(key < array[j] ){
                    array[j+1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+1] = key;
        }
    }
}