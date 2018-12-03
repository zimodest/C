package first.test.java;

import java.lang.reflect.InvocationTargetException;
        import java.lang.reflect.Method;

class Emp{
    private String name;
    private String sex;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
class EmpAction{
    private Emp emp = new Emp();
    public void setValue(String value){
        try {
            Test12_2.setBeanValue(this, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Emp getEmp(){
        return emp;
    }
}

public class Test12_2 {
    public static void main(String[] args){
        String value = "emp.name:zhangsan|emp.sex:male";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
    // 如：emp.name:zhangsan|emp.sex:male
    public static void setBeanValue(Object actionObject, String value)
            throws Exception {
        String[] result = value.split("\\|");
        for(int i=0; i<result.length; i++){
            String[] ret = result[i].split(":");
            // 取得真实要设置的内容
            String realVal = ret[1];
            String[] ret1 = ret[0].split("\\.");
            // 取得要设置的真实类名称
            String className = ret1[0];
            // 取得要设置的属性名称
            String valName = ret1[1];
            Object obj = getObjectValue(actionObject, className);
            // 设置值
            // 1.取得真实类的Class对象
            Class cls = obj.getClass();
            // 2.取得setter方法对象
            String methodName = "set"+initCap(valName);
            System.out.println(methodName);
            Method method = cls.getMethod(methodName, String.class);
            // 3.设置属性
            method.invoke(obj, realVal);
        }
    }

    /**
     * 通过反射取得XXAction中的真实对象
     * @param actionObject
     * @param className 真实类名称
     * @return 返回真实对象Emp
     */
    public static Object getObjectValue(
            Object actionObject, String className){
        // 拼接getEmp()方法名
        String methodName = "get"+initCap(className);
        // 取得Class对象
        Class cls = actionObject.getClass();
        Object obj = null;
        try {
            // 取得Method对象
            Method method = cls.getMethod(methodName);
            try {
                // 相当于调用了empAction.getEmp()方法
                obj = method.invoke(actionObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // 字符串首字母大写
    public static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
