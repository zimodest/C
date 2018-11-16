package www.jin.javapratice;

/**
 * 给定一字符串，将字符串中的值替换成20%
 * 解题思路
 * 利用String类的spilt()方法，将字符串用空格分开成字符串数组
 * 再利用apppend()方法在分开的字符串中间加上20%
 *
 * 测试
 * 用于分割的字符是" "(空格）
 * 字符串首的字符是用于分割字符串的字符时，字符串会被分割成两个部分
 *String string = new String(" hello bit!");
 * System.out.println(string.split(" ").length);
 * 输出为3
 * 字符串尾的字符是用于分割字符串的字符时，只是去掉字符串尾的字符，还是一部分
 * String string = new String("hello bit! ");
 *  System.out.println(string.split(" ").length);
 *  输出是2
 * 空格在字符串首
 * 空格在字符串尾
 */

public class Kongzhuanhuan {
    public static void main(String[] args) {
        String string = new String("hello bit!");
        string =konggeExange(string);
        System.out.println(string);
    }
    //StringBuffer是线程安全的
    //StringBuilder是线程不安全的
    public static String  konggeExange(String string){
        char c = string.charAt(string.length()-1);
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = string.split(" ");
        int i;
        for(i = 0; i < strings.length-1;i++){
            stringBuffer.append(strings[i]).append("20%");
        }

        stringBuffer.append(strings[i]);
        if(c == ' '){
            stringBuffer.append("20%");
        }
        return stringBuffer.toString();
    }
}
