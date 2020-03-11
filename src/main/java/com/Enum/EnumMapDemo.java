package com.Enum;

import java.util.EnumMap;

public class EnumMapDemo {
    private Color color;

    enum Color{
        BLUE,
        RED,
        YELLOW,
        BLACK,
        WHITE,
        GREEN,
        PINK
    }

    public static void main(String[] args) {
        EnumMap<Color,String> e1 = new EnumMap<Color, String>(Color.class);
        e1.put(Color.BLACK,"黑色");
        e1.put(Color.RED,"红色");
        System.out.println(e1.get(Color.RED));
    }
}
