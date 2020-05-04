package com.pattern.Adapter;

public class ObjectAdapter {
    public static void main(String[] args) {
        Adaptee adaptee=new AdapteeClass();
        Target target=new Adapter1(adaptee);
        target.display();
    }
}

// interface Target{
//     public void show();
// }

// class Adaptee{
//     public void display() {
//         System.out.println("display");
//     }
// }


class Adapter1 implements Target{
    private Adaptee adaptee;
    public Adapter1(Adaptee adaptee){
        this.adaptee=adaptee;
    }
    public void display() {
        this.adaptee.show();
    }
}