package Basic;

public class Polymorphism {
    public static void main(String[] args) {
        // Base base=new Child();
        // base.display();
        Father father=new Kid();
        father.show();
    }
}


interface Father{
    public void show();
}


class Kid implements Father{
    public void show(){
        System.out.println("super");
    }
    public void display() {
        System.out.println("kid display");
    }
}


//父类不可以调用子类的方法
class Base{
    public void show() {
        System.out.println("this is father class!");
    }
}

class Child extends Base{
    public void display() {
        System.out.println("this is child class!");
    }
}