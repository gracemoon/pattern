package Responsibility;

public class ChainofResponsibility {
    public static void main(String[] args) {
        School elementary=new Elementary();
        School junior=new Junior();
        School senior=new Senior();
        elementary.setSchool(junior);
        junior.setSchool(senior);
        elementary.operation("senior");
    }
}

abstract class School{
    private School next;
    public void setSchool(School School) {
        this.next=School;
    }
    public School getSchool() {
        return this.next;
    }
    public abstract void operation(String s);
}


class Elementary extends School{
    public void operation(String s) {
        if(s.equals("elementary")){
            System.out.println(s);
        }else if(this.getSchool()!=null){
            this.getSchool().operation(s);
        }else{
            System.out.println("error request!");
        }
    }
}

class Junior extends School{
    public void operation(String s) {
        if(s.equals("junior")){
            System.out.println(s);
        }else if(this.getSchool()!=null){
            this.getSchool().operation(s);
        }else{
            System.out.println("error request!");
        }
    }
}

class Senior extends School{
    public void operation(String s) {
        if(s.equals("senior")){
            System.out.println(s);
        }else if(this.getSchool()!=null){
            this.getSchool().operation(s);
        }else{
            System.out.println("error request!");
        }
    }
}


