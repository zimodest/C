package first.test.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 反射机制与动态代理
 */
interface ISubject{
    void eat();
}
// 真实业务类
class RealSubject implements ISubject{
    @Override
    public void eat() {
        System.out.println("正在吃");
    }
}
// 代理类
class ProxySubject implements InvocationHandler{
    private Object realObject;

    /**
     * 绑定真实主题类
     * @param realObject
     * @return 返回代理类
     */
    public Object bind(Object realObject){
        this.realObject = realObject;
        return Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(), this);
    }
    public void beforeEat(){
        System.out.println("准备吃");
    }
    public void afterEat(){
        System.out.println("吃完了");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeEat();
        // 调用真实主题类方法
        Object result = method.invoke(realObject);
        afterEat();
        return null;
    }
}
public class Test12_3 {
    public static void main(String[] args){
        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat();
    }
}
