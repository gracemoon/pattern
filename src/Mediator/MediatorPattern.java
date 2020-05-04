package Mediator;

import java.util.ArrayList;

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator=new ConcreteMediator();
        Colleague colleagueA=new ConcreteColleague(mediator, "colleague A");
        Colleague colleagueB=new ConcreteColleague(mediator, "colleague B");
        mediator.add(colleagueA);
        mediator.add(colleagueB);
        colleagueA.send();
        colleagueB.send();
    }
}

interface Mediator{
    public void add(Colleague colleague);
    public void action(Colleague colleague);
}

class ConcreteMediator implements Mediator{
    private ArrayList<Colleague> arrayList=new ArrayList<Colleague>();
    public void add(Colleague colleague){
        arrayList.add(colleague);
    }
    public void action(Colleague colleague){
        for(Colleague c:arrayList){
            if(!c.equals(colleague)){
                c.receive();
            }
        }
    }
}

interface Colleague{
    public void send();
    public void receive();
}

class ConcreteColleague implements Colleague{
    private String info;
    private Mediator mediator;
    public ConcreteColleague(Mediator mediator,String info){
        this.mediator=mediator;
        this.info=info;
    }
    public void send() {
        System.out.println(this.info+" has sent.");
        this.mediator.action(this);
    }
    public void receive() {
        System.out.println(this.info+" has received");
    }
}


