package Composite;

import java.util.ArrayList;

public class CompositePattern {
    public static void main(String[] args) {
        Component root=new Tree();
        Component tree=new Tree();
        Component leaf1=new Leaf("leaf 1.");
        Component leaf2=new Leaf("leaf 2.");
        Component leaf3=new Leaf("leaf 3.");
        tree.add(leaf1);
        tree.add(leaf2);
        root.add(tree);
        root.add(leaf3);
        root.operation();
    }
}


interface Component{
    public void add(Component c);
    public void remove(Component c);
    public Component getChild(int i);
    public void operation();
}

class Leaf implements Component{
    private String info;
    public Leaf(String info){
        this.info=info;
    }
    public void add(Component c) {
        
    }
    public void remove(Component c){

    }
    public Component getChild(int i) {
        return null;
    }
    public void operation() {
        System.out.println(this.info);
    }
}

class Tree implements Component{
    private ArrayList<Component> arrayList=new ArrayList<Component>();
    public void add(Component c) {
        arrayList.add(c);
    }
    public void remove(Component c){
        arrayList.remove(c);
    }
    public Component getChild(int i) {
        Component c=arrayList.get(i);
        return c;
    }
    public void operation() {
        for(Component c : arrayList){
            c.operation();
        }
    }
}