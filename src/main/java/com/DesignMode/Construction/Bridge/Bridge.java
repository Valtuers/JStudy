package com.DesignMode.Construction.Bridge;

public class Bridge {
    /**
     * 将抽象部分与实际部分分离，使它们都可以独立的变化
     * 优点：
     *  1、抽象和实现的分离
     *  2、优秀的扩展能力
     *  3、实现细节对客户透明
     * 缺点：
     *  桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程
     */
    public static void main(String[] args) {
        Car bossCar = new BossCar(new HybridEngine());
        bossCar.drive();
    }
}

abstract class Car {
    protected Engine engine;

    Car (Engine engine){
        this.engine = engine;
    }

    public abstract void drive();
}

interface Engine {
    void start();
}

abstract class RefinedCar extends Car {

    RefinedCar(Engine engine) {
        super(engine);
    }

    public void drive(){
        this.engine.start();
        System.out.println("Drive " + getBrand() + "car......");
    }

    public abstract String getBrand();
}

class BossCar extends RefinedCar{

    BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "Boss";
    }
}

class HybridEngine implements Engine {

    @Override
    public void start() {
        System.out.println("start Hybrid Engine...");
    }
}