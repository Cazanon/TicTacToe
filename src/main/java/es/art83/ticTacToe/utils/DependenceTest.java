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
                    throw new AssertionError("Broken dependency \"" + dependence.name()
                            + "\" with: " + Arrays.toString(dependence.dependencies()));
                }
            }
        }
    }

    public void test() {
        for (Method method : clazz.getMethods()) {
            this.testAnotation(method.getName(), method.getAnnotations());
        }
        for (Field field : clazz.getDeclaredFields()) {
            this.testAnotation(field.getName(), field.getAnnotations());
        }
    }
}
