package com.pattern.Observer;

import java.util.ArrayList;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject("subject1");
        Observer observer1=new ConcreteObserver("observer 1");
        Observer observer2=new ConcreteObserver("observer 2");
        Observer observer3=new ConcreteObserver("observer 3");
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);
        subject.operation();
    }
}

interface Subject{
    public void operation();
    public void addObserver(Observer o);
}

class ConcreteSubject implements Subject{
    private String info;
    private ArrayList<Observer> observers=new ArrayList<Observer>();
    public ConcreteSubject(String info){
        this.info=info;
    }
    public void operation() {
        System.out.println(this.info);
        for(Observer o : observers){
            o.dispaly();
        }
    }
    public void addObserver(Observer o) {
        observers.add(o);
    }
}

interface Observer{
    public void dispaly();
}

class ConcreteObserver implements Observer{
    private String info;
    public ConcreteObserver(String info){
        this.info=info;
    }
    public void dispaly() {
        System.out.println(this.info);
    }
}