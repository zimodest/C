package www.jin.java11_13;

public class NumsPFHTest {
    public static void main(String[] args){
//        int num = 1000000000;
        int num = 999999999;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(judgeSquareSum(Integer.MAX_VALUE));

        System.out.println(judgeSquareSum(num));
    }
    public static boolean judgeSquareSum(int c) {
        if(c<0 || c>Integer.MAX_VALUE){
            return false;
        }else if(c==0 || c==1){
            return true;
        }
//        for(int i=0; i<=c/2; i++) {
//            if (i * i < c) {
//                for (int j = 0; j <= c / 2; j++) {
////                if(i*i+j*j == c){
//                    int a = (i + j) * (i + j) - 2 * i * j;
//                    if (a == c) {
//                        return true;
//                    }
//                }
//            }
//        }
//        for(int i = 0;i<c/2;i++){
//            int a = i*i;
//            if(a< c){
//                for(int j = c/2;j>=0;j--){
//                    int b = j*j;
//                    if(b<c){
//                        if(a+b == c)
//                            return true;
//                    }
//                }
//            }
//        }

//        for(int i = c/2;i>=0;i--){
//            int a = i*i;
//            if(a>0 && a< c){
//                for(int j = 0;j<c/2;j++){
//                    int b = j*j;
//                    if(a<b){
//                        break;
//                    }
//                    if(b<c){
//                        if(a+b == c)
//                            return true;
//                    }
//                }
//            }
//        }
        int s = (int)(Math.sqrt(c)/Math.sqrt(2));
        for(int i = c/2;i>=s;i--){
            int a = i*i;
            if(a>0 && a< c){
                int d = (int)Math.sqrt(c-a);
                for(int j = d;j<=i;j++){
                    if(j*j == c-a){
                        return true;
                    }
                }
            }
        }
//        int i = 0,j = c/2;
//        while(i <= j){
//            int a = i*i;
//            int b = j*j;
//            if(a<c && b<c){
//                if(a + b == c){
//                    return true;
//                }
//            }
//            i++;
//            j--;
//        }


        return false;
    }
}
