package Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args) {
        Structure structure=new Structure();
        Element elementA=new ConcreateElementA();
        structure.add(elementA);
        Element elementB=new ConcreateElementB();
        structure.add(elementB);
        Visitor visitor=new ConcreateVisitor();
        structure.accept(visitor);
    }
}

interface Element{
    public void accept(Visitor visitor);
    public void operation();
}

class ConcreateElementA implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public void operation(){
        System.out.println("concrete Element A.");
    }
}

class ConcreateElementB implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public void operation(){
        System.out.println("concrete Element B.");
    }
}

interface Visitor{
    public void visit(ConcreateElementA elementA);
    public void visit(ConcreateElementB elementB);
}

class ConcreateVisitor  implements Visitor{
    public void visit(ConcreateElementA elementA){
        System.out.println("concrete visitor A");
        elementA.operation();
    }
    public void visit(ConcreateElementB elementB){
        System.out.println("concrete visitor B");
        elementB.operation();
    }
}


class Structure{
    private List<Element> list=new ArrayList<Element>();
    public void add(Element e) {
        list.add(e);
    }
    public void accept(Visitor visitor){
        for(Element e:list){
            e.accept(visitor);
        }
    }
}