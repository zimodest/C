import java.util.*;
// interface IMyInterface{
//     public static final String MSG = "test";
//     public abstract void test();
// }

// interface INews{
//     public abstract void getNews();
// }



// public class MyInterface implements IMyInterface,INews{
//     public void test(){
//         System.out.println(MSG);
//     }
//     public void getNews(){
//         System.out.println(MSG);
//     }
//     public static void main(String[] args){
//         IMyInterface myInterface  = new MyInterface();
//         //父接口的相互转换
//         INews news = (MyInterface)myInterface();
//         news.getNews();
//     }
// }


// interface IMyInterface{
//     public abstract void test();
// }
// public class MyInterface implements IMyInterface{
//     public void test(){
//         System.out.println(MSG);
//     }
//     public void getNews(){
//         System.out.println(MSG);
//     }
//     public static void main(String[] args){
//         IMyInterface myInterface  = new MyInterfaceImpl();
//     }
// }


// interface IUSB{
//     void plugIn();
//     void setUP();
//     void work();
// }


// class Mouse implements IUSB{
//     public void plugIn(){
//         System.out.println("鼠标插入接口");
//     }
//     public void setUP(){
//         System.out.println("安装鼠标驱动");
//     }
//     public void work(){
//         System.out.println("鼠标正常工作");
//     }
// }

// class KeyBoard implements IUSB{
//     public void plugIn(){
//         System.out.println("键盘插入接口");
//     }
//     public void setUP(){
//         System.out.println("安装键盘驱动");
//     }
//     public void work(){
//         System.out.println("键盘正常工作");
//     }
// }

// class Computer{
//     public void play(IUSB usb){
//         usb.plugIn();
//         usb.setUP();
//         usb.work();
//     }
// }


// public class MyInterface{
//     public static void main(String[] args){
//         Computer computer = new Computer();
//         computer.play(new Mouse());
//         System.out.println("--------------------------------");
//         computer.play(new KeyBoard());
//     }
// }



//简单工厂模式
// interface Computer{
//     void printComputer();
// }

// class MackBookPro implements Computer{
//     public void printComputer(){
//         System.out.println("This is a mackbookpro");
//     }
// }

// class SurfaceBook implements Computer{
//     public void printComputer(){
//         System.out.println("This is a SurfaceBook");
//     }
// }

// class AlienWare implements Computer{
//     public void printComputer(){
//         System.out.println("This is a AlienWare");
//     }

// }

// //第三方工厂类
// class ComputerFactory{
//     public static Computer getInstance(String type){
//         if(type.equals("mac")){
//             return new MackBookPro();
//         }else if(type.equals("surface")){
//             return new SurfaceBook();
//         }else if(type.equals("alien")){
//             return new AlienWare();
//         }
//         return null;
//     }
// }


// public class MyInterface{
//     //客户端
//     public static void main(String[] args){
//         //Computer computer = new SurfaceBook();
//         System.out.println("请输入您想要的电脑型号...");
//         Scanner scanner = new Scanner(System.in);
//         String type = scanner.nextLine();
//         Computer computer = ComputerFactory.getInstance(type);
//         computer.printComputer();
//     }
// }


//工厂方法模式
class SurfaceBook implements Computer{
    public void printComputer(){
        System.out.println("This is a SurfaceBook");
    }
}

class AlienWare implements Computer{
    public void printComputer(){
        System.out.println("This is a AlienWare");
    }

}


interface ComputerFactory{
    Computer creatComputer();
}


class MsFactory implements ComputerFactory{
    public Computer creatComputer(){
        return new surface();
    }
}
class AppleFactory implements ComputerFactory{
    public Computer creatComputer(){
        return new MackBookPro();
    }
}

public class MyInterface{
    //客户端
    public static void main(String[] args){
        //Computer computer = new SurfaceBook();
        System.out.println("请输入您想要的电脑型号...");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        Computer computer = ComputerFactory.getInstance(type);
        computer.printComputer();
    }
}