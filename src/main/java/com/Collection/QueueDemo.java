package com.Collection;

import java.util.*;

public class QueueDemo {
    /*
        Queue实现了一个先进先出(FIFO)的数据结构
        通过 add/offer() 方法将元素添加到队尾
        通过 remove/poll() 从队首获取元素并删除
        通过 element/peek() 从队首获取元素但不删除
        要避免把 null 添加到队列
     */
    public void queue(){
        Queue<String> q = new LinkedList();
        q.offer("1");
        q.offer("2");

        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.peek());
    }

    /*
        PriorityQueue是优先队列，总是获取优先级最高的元素
        必须实现Comparable接口，也可以通过Comparator自定义排序算法
     */
    public void priorityQueue(){
        // 基本类型实现了Comparable接口
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(2);
        q.offer(3);
        q.offer(1);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        // 自定义类型要实现Comparator接口自定义排序算法
        Queue<User> q2 = new PriorityQueue<>(new User());
        q2.offer(new User("libai",1));
        q2.offer(new User("V-luxun",555));
        q2.offer(new User("V-linbiao",2));

        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
    }

    /*
        Deque实现一个双端队列，也可以当作 Stack 使用：
        将元素添加到队尾或队首： addLast()/offerLast()/addFirst()/offerFirst()
        从队首或队尾获取元素并删除： removeLast()/pollLast()/removeFirst()/pollFirst()
        从队首或队尾获取元素但不删除： getLast()/peekLast()/getFirst()/peekFirst()
        总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开
        避免把null添加到队列
     */
    public void dequeDemo(){
        Deque<String> d = new LinkedList<>();
        d.offerLast("1");
        d.offerFirst("2");
        d.offerLast("3");

        System.out.println(d.peekLast());
        System.out.println(d.peek());
    }

    public static void main(String[] args) {
        QueueDemo queueDemo = new QueueDemo();
        queueDemo.queue();
        queueDemo.priorityQueue();
        queueDemo.dequeDemo();
    }
}

class User implements Comparator<User>{
    public String name;
    public Integer number;

    public User() {}

    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compare(User o1, User o2) {
        if(o1.name.charAt(0) == o2.name.charAt(0)) {
            // 号码小的排前面
            return o1.number.compareTo(o2.number);
        }
        // V开头的为VIP用户
        if(o1.name.charAt(0) == 'V'){
            return -1;
        }else{
            return 1;
        }
    }
}
