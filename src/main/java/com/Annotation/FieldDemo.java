package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class FieldDemo {

    @FormatField(min = 10,max = 55,value = 22)
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        Field[] fields = FieldDemo.class.getDeclaredFields();
        for(Field f : fields){
            FormatField annotation = f.getAnnotation(FormatField.class);
            if(annotation != null){
                System.out.println("min: "+annotation.min());
                System.out.println("max: "+annotation.max());
                System.out.println("value: "+annotation.value());
            }
        }
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FormatField {
    int min() default 0;
    int max() default 99;
    int value() default 0;
}
