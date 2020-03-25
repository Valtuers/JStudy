package com.DesignMode.Creational.Factory;

public class MethodFactory {
    public static void main(String[] args) {
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        AppleFactory appleFactory = new AppleFactory();
        xiaoMiFactory.makePhone();
        appleFactory.makePhone();
    }
}

interface AFactory {
    Phone makePhone();
}

class XiaoMiFactory implements AFactory {

    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}

class AppleFactory implements AFactory {

    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}
