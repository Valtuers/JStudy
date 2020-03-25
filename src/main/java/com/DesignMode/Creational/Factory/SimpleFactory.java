package com.DesignMode.Creational.Factory;

public class SimpleFactory {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.makePhone("MiPhone");
    }
}

interface Phone {
    void make();
}

class MiPhone implements Phone {

    MiPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("生产了一台小米手机！！！");
    }
}

class IPhone implements Phone {

    IPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("生产了一台苹果手机！！！");
    }
}

class PhoneFactory {
    public Phone makePhone(String type){
        if(type.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }else if(type.equalsIgnoreCase("IPhone")){
            return new IPhone();
        }
        return null;
    }
}
