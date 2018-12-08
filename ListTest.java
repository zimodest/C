package www.jihe;

import java.util.ArrayList;
import java.util.List;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(this == null){
            return false;
        }
        if(!(obj instanceof Person)){
            return false;
        }

        Person person = (Person)obj;
        return false;
    }
}
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add(new String("hello"));
        list.add(new String("world"));
        list.add(new String("bit"));
        list.add(new String("hello"));
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        boolean a = list.contains(new String("hello"));
        System.out.println(a);
        list.clear();
    }
}
