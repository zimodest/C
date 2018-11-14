package www.jin.java11_13;
class Lazy{
    String name = null;
    private Lazy(String name){
        this.name = name;
    }
    public static Lazy getObject(String name){
        return new Lazy(name);
    }
}
public class LazyDanLiTest {
}
