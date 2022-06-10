package edu.study.book.chapter14;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class AnnotationTest {
    public int number = 10;
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        test01();
    }

    public static void test01() throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] annotations = Class.forName("edu.study.book.chapter14.AnnotationTest").getMethod("printElement").getAnnotations();
        for (Annotation annotation: annotations) {
            if (annotation instanceof MyAnnotation) {
                System.out.println(((MyAnnotation)annotation).name());
                System.out.println(((MyAnnotation)annotation).age());
                System.out.println(((MyAnnotation)annotation).value());
                continue;
            }
            System.out.println(annotation);
        }
    }

    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        for (Method method: Class.forName(clazz).getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Exception exception) {
                    failed++;
                }
            }
        }
        System.out.println(passed + "  " + failed);
    }

    @Deprecated
    @MyAnnotation("value")
    public void printElement() {
        System.out.println(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnnotationTest)) return false;
        AnnotationTest that = (AnnotationTest) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
