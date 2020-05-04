package Decorator;

public class ConcreteDecorator {
    public static void main(String[] args) {
        Component concreteComponent=new ConcreteComponent();
        Decorator decorator=new ConcreteDecorator1(concreteComponent);
        decorator.operation();
    }
}


interface Component{
    public void operation();
}

class ConcreteComponent implements Component{
    public void operation() {
        System.out.println("this is concrete component.");
    }
}

class Decorator implements Component{
    Component component;
    public Decorator(Component component){
        this.component=component;
    }
    public void operation(){
        this.component.operation();
    }
}

class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    public void operation() {
        super.operation();
        addOperation();
    }
    public void addOperation() {
        System.out.println("add operation.");
    }
}