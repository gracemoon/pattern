package com.pattern.Flyweight;

public class FlyweightPattern {
    public static void main(String[] args) {
        
    }
}


class UnsharedFlyweight{
    private String info;

    public UnsharedFlyweight(String info) {
        this.info=info;
    }

    public void show() {
        System.out.println(this.info);
    }
}


interface Flyweight{
    public void operation(UnsharedFlyweight state);
}



class ConcreteFlyweight implements Flyweight{
    private UnsharedFlyweight state;
    public ConcreteFlyweight(UnsharedFlyweight state){
        this.state=state;
    }
    public void operation(UnsharedFlyweight state){
        this.state.show();
    }
}

