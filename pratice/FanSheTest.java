package www.jin.java;

interface IFruit{
    void eat();
}

class Apple implements IFruit{
    @Override
    public void eat() {
        System.out.println("eat an Apple");
    }
}

class Pear implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat a Pear");
    }
}

class Factory{
    private Factory(){}

    public static IFruit getInstance(String className){
        IFruit iFruit = null;
        try {
            //
            Class<?> cls = Class.forName(className);
            //通过反射取得实例化对象
            iFruit = (IFruit)cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return iFruit;
    }
}

public class FanSheTest {
    public static void main(String[] args) {
        IFruit iFruit = Factory.getInstance("www.jin.java.Apple");
        iFruit.eat();
    }
}
