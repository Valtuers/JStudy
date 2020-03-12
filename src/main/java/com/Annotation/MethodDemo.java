package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class MethodDemo {

    @MethodFormat("hahaha")
    public void hello(){}

    public static void main(String[] args) {
        Method[] methods = MethodDemo.class.getMethods();
        for(Method m : methods){
            MethodFormat annotation = m.getAnnotation(MethodFormat.class);
            if(annotation != null){
                System.out.println(annotation.value());
            }
        }
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodFormat{
    String value() default "";
}
