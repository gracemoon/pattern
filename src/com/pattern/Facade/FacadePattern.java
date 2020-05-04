package com.pattern.Facade;

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.show();
    }
}



class Facade{
    private System1 system1=new System1();
    private System2 system2=new System2();
    private System3 system3=new System3();
    public void show() {
        system1.show();
        system2.show();
        system3.show();
    }
}

class System1{
    public void show(){
        System.out.println("system1.");
    }
}
class System2{
    public void show(){
        System.out.println("system2.");
    }
}
class System3{
    public void show(){
        System.out.println("system3.");
    }
}
