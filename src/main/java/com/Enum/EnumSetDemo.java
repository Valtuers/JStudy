package com.Enum;

import java.util.EnumSet;

public class EnumSetDemo {
    private Color color;

    public enum Color {
        BLUE,
        RED,
        YELLOW,
        BLACK,
        WHITE,
        GREEN,
        PINK
    }

    public static void main(String[] args) {
        //1.创建一个包含Color所有枚举值的EnumSet集合
        EnumSet<Color> e1 = EnumSet.allOf(Color.class);
        System.out.println(e1);
        //2.创建一个空的EnumSet集合
        EnumSet<Color> e2 = EnumSet.noneOf(Color.class);
        System.out.println(e2);
        e2.add(Color.BLUE);
        e2.add(Color.PINK);
        System.out.println(e2);
        //3.以制定枚举值创建集合
        EnumSet<Color> e3 = EnumSet.of(Color.BLUE, Color.WHITE, Color.GREEN);
        System.out.println(e3);
        //4.创建一个从from到to枚举值范围内所有枚举值的集合
        EnumSet<Color> e4 = EnumSet.range(Color.RED, Color.GREEN);
        System.out.println(e4);
        //5.创建一个不包含传入的集合里的枚举值的新集合
        EnumSet<Color> e5 = EnumSet.complementOf(e4);
        System.out.println(e5);
    }
}
