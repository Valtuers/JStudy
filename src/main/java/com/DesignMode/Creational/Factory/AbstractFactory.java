package com.DesignMode.Creational.Factory;

public class AbstractFactory {
    public static void main(String[] args) {
        XiaoMiFactory2 xiaoMiFactory2 = new XiaoMiFactory2();
        AppleFactory2 appleFactory2 = new AppleFactory2();
        xiaoMiFactory2.makePhone();
        xiaoMiFactory2.makePC();
        appleFactory2.makePhone();
        appleFactory2.makePC();
    }
}

interface PC {
    void make();
}

class XiaoMiPc implements PC {

    @Override
    public void make() {
        System.out.println("生产了一台小米电脑！！！");
    }
}

class MAC implements PC {

    @Override
    public void make() {
        System.out.println("生产了一台苹果电脑！！！");
    }
}

interface AbFactory {
    Phone makePhone();
    PC makePC();
}

class XiaoMiFactory2 implements AbFactory {

    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        return new XiaoMiPc();
    }
}

class AppleFactory2 implements AbFactory {

    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public PC makePC() {
        return new MAC();
    }
}
