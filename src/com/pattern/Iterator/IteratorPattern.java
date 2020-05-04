package com.pattern.Iterator;

import java.util.ArrayList;

public class IteratorPattern {
    public static void main(String[] args) {
        Aggregation aggregation=new ConcreteAggregation();
        aggregation.add("add");
        aggregation.add("substract");
        aggregation.add("multiply");
        aggregation.add("divide");
        Iterator iterator=aggregation.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


interface Iterator{
    public Object next();
    public Object first();
    public boolean hasNext();
}


class ConcreteIterator implements Iterator{
    private ArrayList<Object> arrayList=new ArrayList<Object>();
    public ConcreteIterator(ArrayList<Object> arrayList){
        this.arrayList=arrayList;
    }
    Integer index=-1;
    public Object first(){
        index=0;
        return arrayList.get(index);
    }
    public Object next(){
        return arrayList.get(++index);
    }
    public boolean hasNext(){
        if(index<arrayList.size()-1){
            return true;
        }
        return false;
    }
}

interface Aggregation{
    public void add(Object s);
    public void remove(Object s);
    public Iterator getIterator();
}

class ConcreteAggregation implements Aggregation{
    private ArrayList<Object> arraylist=new ArrayList<Object>();
    public void add(Object s){
        arraylist.add(s);
    }
    public void remove(Object s){
        arraylist.remove(s);
    }
    public Iterator getIterator(){
        return new ConcreteIterator(arraylist);
    }
}


