package Memonto;

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator=new Originator("initilizing state.");
        CareTaker caretaker=new CareTaker();
        caretaker.setMemonto(originator.createMemonto());
        System.out.println(originator.getState());
        originator.setState("changed state");
        System.out.println(originator.getState());
        caretaker.getMemonto(originator);
        System.out.println(originator.getState());
    }
}

class Originator{
    private String state;
    public Originator(String state){
        this.state=state;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state=state;
    }
    public Memonto createMemonto() {
        Memonto m=new Memonto();
        m.setState(this.state);
        return m;
    }

    public void restoreMemonto(Memonto m) {
        this.state=m.getState();
    }
}

class Memonto{
    private String state;
    public void setState(String state) {
        this.state=state;
    }
    public String getState() {
        return this.state;
    }
}


class CareTaker{
    private Memonto m;
    public void setMemonto(Memonto m) {
        this.m=m;
    }
    public void getMemonto(Originator o) {
        o.restoreMemonto(this.m);
    }
}