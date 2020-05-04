package Command;

public class CommandPattern {
    public static void main(String[] args) {
        Receiver receiver=new ConcreteReceiver();
        Command command=new ConcreteCommand(receiver);
        Invoker invoker=new Invoker(command);
        invoker.call();
    }
}


class Invoker{
    private Command command;
    public Invoker(Command command){
        this.command=command;
    }
    public void setCommand(Command command) {
        this.command=command;
    }
    public void call(){
        this.command.execute();
    }
}


interface Command{
    public void execute();
}


class ConcreteCommand implements Command{
    private Receiver receiver;
    public ConcreteCommand(Receiver receiver){
        this.receiver=receiver;
    }
    public void execute() {
        System.out.println("show command.");
        this.receiver.show();
    }
}

interface Receiver{
    public void show();
}

class ConcreteReceiver implements Receiver{
    public void show() {
        System.out.println("showing");
    }
}