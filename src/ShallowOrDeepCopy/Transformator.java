package ShallowOrDeepCopy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {
    
    @SuppressWarnings("unchecked")
    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

        
        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(targetField -> {
                    validate(sourceField, targetField);
                    try {
                        targetField.set(targetClass, sourceField.get(input));
                    } catch (IllegalAccessException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }));

        return targetClass;
    }

    private void validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        }
    }
}
