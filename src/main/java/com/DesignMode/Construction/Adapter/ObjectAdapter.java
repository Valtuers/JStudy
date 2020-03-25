package com.DesignMode.Construction.Adapter;

public class ObjectAdapter {
    public static void main(String[] args) {
        Bots2 bots2 = new Bots2(new People());
        bots2.run();
        bots2.kill();
    }
}

class Bots2 implements Machine {
    private People people;

    public Bots2(People people){
        this.people = people;
    }

    public void run(){
        this.people.run();
    }

    @Override
    public void kill() {
        System.out.println("杀人啦2！！！");
    }
}
