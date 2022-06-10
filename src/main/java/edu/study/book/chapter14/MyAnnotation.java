package edu.study.book.chapter14;

import java.lang.annotation.*;

//元注解
//只需要给value成员变量赋值时，可以不用加value=
@Retention(value = RetentionPolicy.RUNTIME) //注解保留到什么阶段
@Target(value = ElementType.METHOD) //指该注解可以修饰哪些程序单元
@Documented //该注解将被javadoc提取，API文档中将包含该注解说明
@Inherited //某个类被修饰，子类也将被该注解修饰
public @interface MyAnnotation {
    String name() default "hello";
    int age() default 12;
    String value(); //可是任意数据类型，主要是注解处理工具
}
