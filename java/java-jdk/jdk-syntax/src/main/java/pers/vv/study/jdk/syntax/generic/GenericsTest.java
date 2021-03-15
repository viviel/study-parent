package pers.vv.study.jdk.syntax.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

public class GenericsTest {

    public void test() {
        // Warning "raw use of parameterized class 'Collection'"
        final List<Collection<Integer>> collection = getStaticFieldValues(Container1.class, Collection.class);
        List<Object> string = getStaticFieldValues(Container2.class, String.class);
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> getStaticFieldValues(Class<?> fieldSource, Class<?> fieldType) {
        List<T> values = new ArrayList<>();
        Field[] declaredFields = fieldSource.getDeclaredFields();
        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers()) && fieldType.isAssignableFrom(field.getType())) {
                try {
                    final T fieldValue = (T) field.get(null);
                    values.add(fieldValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error getting static field values");
                }
            }
        }
        return values;
    }

    public static class Container1<T> {
        public static Collection<String> elements = asList("A", "B", "C");
    }

    public static class Container2<T> {
        public static Collection<String> elements = asList("A", "B", "C");
    }

}