// public class Test{
//     public static void main(String[] args){

//         //System.out.println("hello world");
//         //System.out.print(10/4);

//         /*
//         int line = 10;
//         for (int x = 0; x < line; x++) { //控制行数
//         for (int y = 0; y < line -x ; y++) {//控制空格
//         System.out.print(" ");
//         }
//         for (int z = 0; z < x ; z++ ) {
//         System.out.print("* ");
//         }
//         System.out.println();
//         }
//             }
//         */
//         //读取字符
//     //    char c = System.in.read();
//         //读取字符串
//     //    Scanner scanner = new Scanner(System.in);
//     //    String str = scanner.nexline();
//     //
//     //int[] x = new int[3];
//     //x[0] = 10;
//     //x[1] = 20;
//     //x[2] = 30;
//     //int [] temp = x;
//     //temp[2]=20;




//    // int[] data = new int[]{1,2,3,4,5,6};
//     //System.out.print(data.length);



//     //System.out.print(new int[]{1,2,3,4,5,6}[0]);

//     int[][] data = new int[][]{{1,2},{3,4,5},{6,7,8,9,10}};

//     for(int x=0;x<data.length;x++){
//         for(int y=0;y<data[x].length;x++){
//             System.out.print(data[x][y]+"");
//         }
//     }
//     }


// }
class Outter{
    private String msg="";
    public void test(){
        Inner in = new Inner(this);    
        }   
}
class Inner{
        private String inmsg="";
        public void fun(){
            System.out.print();
        }
    }

class C{
    class InnreClassA extends A{
        public String name(){
            return super.getMg;
        }
    }
    class InnreClassB extends B{
        public int age(){
            return super.geyAge();
        }
    }
    public String name(){
        return new InnreClassA().name();
    }
    public int age(){
        return new InnreClassB().age();
    }
}

public class Test{
    public static void mian(String[] args){
        Outter out = new Outter();
        out.test();
    }
}