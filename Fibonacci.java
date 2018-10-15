public class Fibonacci{
    public static void main(String[] args){
         //In static function ,you must use the static function.
         //Unable to reference non static method from static context.
        System.out.println(Fibonacci(5));
        Fibonacci1(5);
        System.out.println("");

        Fibonacci2(5);
    }

    //recursion 
    public static int Fibonacci(int i){
        if(i<3){
            return 1;
        }
        return Fibonacci(i-1)+Fibonacci(i-2);       
    }

    //loop
    public static void Fibonacci1(int i){
        int a = 1;
        int b = 1;
        int c ;
        int j = 2;
        j=2;
        while((i-2)>0){
            if(j>0){
                System.out.print(1+" ");
                j--;
                continue;
            }
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
            i--;
        }
    }

    public static void Fibonacci2(int i){
    int a = 1;
    int b = 1;
    int c ;
    int j;    
    for(j=1;j<=i;j++){
        if(j == 1 || j == 2){
            System.out.print(1+" ");
            continue;
        }
        c = a+b;
        System.out.print(c+" ");
        a = b;
        b = c;
    }
}

  
}



