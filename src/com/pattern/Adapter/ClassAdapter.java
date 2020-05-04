package com.pattern.Adapter;

public class ClassAdapter {
    public static void main(String[] args) {
        Target target=new Adapter();
        target.display();
    }
}

interface Target{
    public void display();
}

interface Adaptee{
    public void show();
}

class AdapteeClass implements Adaptee{
    public void show() {
        System.out.println("show");
    }
}

class Adapter extends AdapteeClass implements Target{
    public void display() {
        super.show();
    }
}




