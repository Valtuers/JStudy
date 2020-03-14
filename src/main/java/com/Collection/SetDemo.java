package com.Collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    /*
        HashSet和TreeSet比较：
        HashSet是无序的，TreeSet是有序的
     */
    public void HashSetDemo(){
        Set<String> s1 = new HashSet<>();
        s1.add("aaa");
        s1.add("bbb");
        s1.add("ccc");

        for(String s : s1){
            System.out.println(s);
        }

        System.out.println(s1.contains("aaa"));
        System.out.println(s1.contains("YYY"));
        System.out.println(s1.remove("bbb"));
        System.out.println(s1.size());
    }

    public void TreeSetDemo(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("aaa");
        treeSet.add("bbb");
        treeSet.add("ccc");

        for(String s : treeSet){
            System.out.println(s);
        }

        System.out.println(treeSet.contains("aaa"));
        System.out.println(treeSet.contains("YYY"));
        System.out.println(treeSet.remove("bbb"));
        System.out.println(treeSet.size());

    }

    public static void main(String[] args) {
        SetDemo setDemo = new SetDemo();
        setDemo.HashSetDemo();
        setDemo.TreeSetDemo();
    }
}
