package www.jin.java;

import java.lang.reflect.Method;

class Person{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//反射调用普通方法
public class FanShe_PTfnagfa  {
    public static void main(String[] args) throws  Exception {
        //获取Person反射对象
        Class<?> cls = Person.class;
        //创建Person类实例化对象
        Person per = (Person)cls.newInstance();
        //拿到setName的Method对象
        Method method = cls.getMethod("setName", String.class);
        //通过invoke进行调用
        method.invoke(per,"蛋哥");
        System.out.println(per);

    }
}
