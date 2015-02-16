package es.art83.ticTacToe.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DependenceTest {
    private Class<?> clazz;

    
    public DependenceTest(Class<?> clazz) {
        this.clazz = clazz;
    }

    private void testAnotation(String name, Annotation[] Annotations) {
        for (Annotation annotation : Annotations) {
            if (annotation.annotationType().equals(Dependence.class)) {
                Dependence dependence = (Dependence) annotation;
                if (!name.equals(dependence.name())) {
                    // throw new DependenceException(dependence.name(),
                    // Arrays.toString(dependence.dependencies()));
                    throw new AssertionError("Broken dependency \"" + dependence.name()
                            + "\" with: " + Arrays.toString(dependence.dependencies()));
                }
            }
        }
    }

    public void test() {
        Method[] metodos = clazz.getMethods();

        for (Method method : metodos) {
            testAnotation(method.getName(), method.getAnnotations());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            testAnotation(field.getName(), field.getAnnotations());
        }

    }

}
