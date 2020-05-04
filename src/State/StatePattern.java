package State;

public class StatePattern {
    public static void main(String[] args) {
        Context context=new Context();
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }
}


class Context{
    private State state;
    public Context(){
        this.state=new Synchronous();
    }
    public void setState(State state){
        this.state=state;
    }
    public void handle() {
        this.state.handle(this);
    }
}

interface State{
    public void handle(Context context);
}

class Synchronous implements State{
    public void handle(Context context) {
        System.out.println("Synchronous");
        context.setState(new Asynchronous());
    }
}

class Asynchronous implements State{
    public void handle(Context context) {
        System.out.println("Asynchronous");
        context.setState(new Synchronous());
    }
}





