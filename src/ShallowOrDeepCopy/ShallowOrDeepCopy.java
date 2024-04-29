package ShallowOrDeepCopy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The {@code ShallowOrDeepCopy} class provides methods for verifying and creating deep copies of objects.
 * It handles both shallow and deep copying based on the object's properties.
 */
public class ShallowOrDeepCopy {

    /**
     * Verifies if the input object is {@link Cloneable} and returns a deep copy if possible.
     *
     * @param data The object to be verified and copied.
     * @return If {@code data} is {@link Cloneable}, a deep copy of {@code data}.
     *         Otherwise, the original {@code data}.
     */
    public static Object verifyAndCopy(Object data) {
        if (data instanceof Cloneable)
            return deepCopy(data);
        return data;
    }

    /**
     * Creates a deep copy of the input object.
     *
     * @param data The object to be deeply copied.
     * @return A deep copy of {@code data}.
     */
    public static Object deepCopy(Object data) {
        try {
            Class<?> x = data.getClass();
            Method method = x.getMethod("clone");
            return method.invoke(data);
        } catch (InvocationTargetException |
                 NoSuchMethodException |
                 IllegalAccessException ignored) {
            return data;
        }
    }
}