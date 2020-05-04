package Strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Strategy strategy1=new ConcreteStrategy1();
        Strategy strategy2=new ConcreteStrategy2();
        Context context=new Context(strategy1);
        context.operation();
        context.setStrategy(strategy2);
        context.operation();
    }
}



interface Strategy{
    public void operation();
}


class ConcreteStrategy1 implements Strategy{
    public void operation() {
        System.out.println("this is 1 strategy.");
    }
}

class ConcreteStrategy2 implements Strategy{
    public void operation() {
        System.out.println("this is 2 strategy.");
    }
}

class Context{
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public void operation() {
        this.strategy.operation();
    }
}