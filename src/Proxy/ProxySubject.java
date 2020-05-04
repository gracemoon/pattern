package Proxy;

public class ProxySubject {
    public static void main(String[] args) {
        Proxy proxy=new Proxy();
        proxy.display();
    }
}

interface Subject{
    public void display();
}


class RealSubject implements Subject{
    public void display() {
        System.out.println("this is real subject!");
    }
}

class Proxy implements Subject{
    private Subject realSubject=new RealSubject();
    public void display() {
        this.realSubject.display();
    }
}