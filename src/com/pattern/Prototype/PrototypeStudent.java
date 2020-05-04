package com.pattern.Prototype;

public class PrototypeStudent implements Cloneable{
    public String name;
    public String college;
    
    public PrototypeStudent(String college,String name){
        this.college=college;
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void display() {
        System.out.println(this.name);
    }
    public Object clone() throws CloneNotSupportedException{
        return (PrototypeStudent)super.clone();
    }
}