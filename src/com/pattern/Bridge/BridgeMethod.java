package com.pattern.Bridge;

public class BridgeMethod{
    public static void main(String[] args) {
        Color red=new Red();
        Color blue=new Blue();
        Bag handBag=new HandBag(red);
        handBag.operation();
        Wallet wallet=new Wallet(blue);
        wallet.operation();
    }
}

interface Color{
    void printColor();
}


class Blue implements Color{
    public void printColor() {
        System.out.println("blue");
    }
}

class Red implements Color{
    public void printColor() {
        System.out.println("red");
    }
}


abstract class Bag{
    protected Color color;
    public Bag(Color color){
        this.color=color;
    } 
    public abstract void operation();
}


class HandBag extends Bag{
    public HandBag(Color color) {
        super(color);
    }

    public void operation() {
        this.color.printColor();
        System.out.println("HandBag");
    }
}

class Wallet extends Bag{
    public Wallet(Color color) {
        super(color);
    }

    public void operation() {
        this.color.printColor();
        System.out.println("Wallet");
    }
}



