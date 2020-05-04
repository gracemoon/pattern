package com.pattern;
public class Test {
    public static void main(String[] args) {
        Student student=new Student("李明");
        System.out.println(student.getName());
        Operation operation=new Operation();
        String str="train";
        System.out.println(str);
        operation.setName(student,str);
        System.out.println(student.getName());
        System.out.println(str);
    }


}

class Operation{
    public void setName(Student student,String str) {
        student=new Student("test");
        str="test";
    }
}


class Student {
    private String name;
    public Student(String name) {
        this.name=name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name=name;
    }
}