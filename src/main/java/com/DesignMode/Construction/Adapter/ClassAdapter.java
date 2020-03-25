package com.DesignMode.Construction.Adapter;

public class ClassAdapter {

    public static void main(String[] args) {
        Bots bots = new Bots();
        bots.run();
        bots.kill();
    }
}

class People {
    public void run(){
        System.out.println("跑起来了！！！");
    }
}

interface Machine {
    void kill();
}

class Bots extends People implements Machine {

    @Override
    public void kill() {
        System.out.println("杀人啦！！！");
    }
}
