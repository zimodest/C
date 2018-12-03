package first.test.java;

/**
 * 反射实现简单工厂
 */
interface IFruit{
    void eat();
}
class Orange implements IFruit{
    @Override
    public void eat() {
        System.out.println("eat an oriange");
    }
}
class Apple implements IFruit{
    @Override
    public void eat() {
        System.out.println("eat an apple");
    }
}
class Factory{
    public static IFruit getInstance(String className)
            throws IllegalAccessException, InstantiationException {
        IFruit fruit = null;
        Class<?> cls = null;
        try {
            cls = Class.forName(className);
            fruit = (IFruit)cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
public class Test12 {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException {
        // 类名可以通过命令行输入
        IFruit fruit = Factory.getInstance("first.test.java.Apple");
        fruit.eat();
    }
}
