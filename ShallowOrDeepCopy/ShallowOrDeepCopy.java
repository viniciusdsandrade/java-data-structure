package ShallowOrDeepCopy;

import java.lang.reflect.Method;

public class ShallowOrDeepCopy {
    public static Object verifyAndCopy(Object data) {
        if(data instanceof Cloneable) return deepCopy(data);
        else return data;
    }

    public static Object deepCopy(Object data) {
        try {
            Class<?> x = data.getClass();
            Method method = x.getMethod("clone");
            return (Object)method.invoke(data);
        } catch(Exception err) { return null; }
    }
}