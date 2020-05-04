package Interpreter;

import java.util.HashSet;
import java.util.Set;

public class InterpreterPattern {
    public static void main(String[] args) {
        Context context =new Context();
        context.interpreter("A&&a");
        System.out.println("a&&e".split("&&")[0]);
        context.interpreter("d&&e");
    }
}

interface Expression{
    public boolean interpreter (String s);
}

class Terminal implements Expression{
    private Set<String> set=new HashSet<String>();
    public Terminal(String[] data){
        for(String s : data){
            set.add(s);
        }
    }
    public boolean interpreter(String s) {
        if(set.contains(s)){
            return true;
        }
        return false;
    }
}


class NonTerminal implements Expression{
    private Expression expression1;
    private Expression expression2;
    public NonTerminal(Expression expression1,Expression expression2){
        this.expression1=expression1;
        this.expression2=expression2;
    }
    public boolean interpreter(String s) {
        String[] ss=s.split("&&");
        if(expression1.interpreter(ss[0]) && expression2.interpreter(ss[1])){
            return true;
        }
        return false;
    }
}


class Context{
    private String[] list1={"A","B","C"};
    private String[] list2={"a","b","c"};
    private NonTerminal nonTerminal;
    public Context(){
        Terminal terminal1=new Terminal(list1);
        Terminal terminal2=new Terminal(list2);
        nonTerminal=new NonTerminal(terminal1, terminal2); 
    }
    public void interpreter(String s){
        if(nonTerminal.interpreter(s)){
            System.out.println("True expression");
        }else{
            System.out.println("False expression");
        }
    }
}