package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@ClassFormat("/class")
public class ClassDemo {

    public static void main(String[] args) {
        ClassFormat annotation = ClassDemo.class.getAnnotation(ClassFormat.class);
        if(annotation != null){
            System.out.println(annotation.value());
        }
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassFormat{
    String value() default "";
}
