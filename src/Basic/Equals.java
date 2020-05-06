package Basic;

public class Equals {
    public static void main(String[] args) {
        Bird dove1=new Dove("black");
        Bird dove2=new Dove("black");
        Bird dove3=dove1;
        if(dove1==dove2){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        if(dove1==dove3){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        if(dove1.equals(dove2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        if(dove1.equals(dove3)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

interface Bird{
    public void fly();
}

class Dove implements Bird{
    private String name;
    public Dove(String name) {
        this.name=name;
    }
    public void fly() {
        System.out.println(this.name);
    }

    public boolean equals(Object obj) {
        return this.name.equals(((Dove)obj).name);
    }
}