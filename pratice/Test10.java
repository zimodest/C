public class Test10{

    public static void main(String[] args) {
        
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7=9;
        
        b3=(b1+b2);  /*语句1*/ //error
		b6=b4+b5;    /*语句2*/ //
		//b8=(b1+b4);  /*语句3*/ //error
		//b7=(b2+b5);  /*语句4*/ //error
        System.out.println(b3+b6);
    }
}