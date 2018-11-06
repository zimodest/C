import java.util.*;
public class javaGuessNumberGame11_6{
    public static void main(String[] args){
        guessNumber();
    }

    public static void guessNumber(){
        int b = 50;
        int number;
        while(true){
            System.out.println("请输入一个数");
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            if(number > b){
                System.out.print("大了,请重新输入");
            }
            if(number<b){
                System.out.println("小了， 请重新输入");
            }
            if(number == b){
                System.out.println("恭喜你赢了");
                return;
            }
        }
    }
}