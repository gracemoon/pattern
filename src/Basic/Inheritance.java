package Basic;

public class Inheritance {
    public static void main(String[] args) {
        Person person=new ScienceStudent();
        person.show();

        Student student=new ScienceStudent();
        student.display();
        student.show();
    }
}


interface Person{
    public void show();
}

//接口可以继承接口
interface Student extends Person{
    public void display();
}

class ScienceStudent implements Student{

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void display() {
        System.out.println("display");
    }
}