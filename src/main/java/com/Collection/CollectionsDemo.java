package com.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    //排序
    public void sort(List<Integer> list){
        Collections.sort(list);
        for(Integer i : list){
            System.out.println(i);
        }
    }

    //洗牌
    public void shuffle(List<Integer> list){
        Collections.shuffle(list);
        for(Integer i : list){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(){{
            add(5);
            add(4);
            add(1);
            add(6);
        }};
        CollectionsDemo collectionsDemo = new CollectionsDemo();
//        collectionsDemo.sort(list);
        collectionsDemo.shuffle(list);
    }
}
