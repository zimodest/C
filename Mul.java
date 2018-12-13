public class Mul{
    
    public static void mulitTable(int row, int col){
        System.out.println(row + "*"+ col +" mulitTable");
        for(int i=1;i<=row;i++){
            for(int j=1;j <=i;j ++){
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        } 
    }
    
    public static void main(String [] args){
        mulitTable(5,5);
    }
}