package Java_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOperation {

    private BeanOperation(){};
    public static void setBeanValue(EmpAction empAction, String msg) throws Exception {
        String[] result = msg.split("\\|");
        for(int i = 0;i< result.length;i++){
            String[] temp = result[i].split(":");

            String realValue = temp[1];
            String realClassName = temp[0].split("\\.")[0];

            String attrName = temp[0].split("\\.")[1];
            Object realObject = getRealObject(empAction,realClassName);
            String setName = "set"+initCap(attrName);
            Class<?> cls = realObject.getClass();
            Method method = cls.getDeclaredMethod(setName,String.class);
            method.invoke(realObject,realValue);

        }
    }
    private static Object getRealObject(Object actionobj, String realClassName){
        Class<?> cls = actionobj.getClass();
        String methodName = "get"+initCap(realClassName);
        System.out.println(methodName);
        Object realobj = null;
        try {
            Method method = cls.getDeclaredMethod(methodName);
            try {
                realobj = method.invoke(actionobj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return realobj;
    }

    private static String initCap(String string){
        return string.substring(0,1).toUpperCase()+
                string.substring(1);
    }
}
