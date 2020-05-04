import Singleton.HungrySingleton;
import Prototype.PrototypeStudent;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        //hungrySingleton
        HungrySingleton instance=HungrySingleton.getInstance();
        instance.printSentence();


        //Prototype
        PrototypeStudent student1=new PrototypeStudent("ECNU", "李明");
        student1.display();
        PrototypeStudent student2=(PrototypeStudent)student1.clone();
        student2.setName("张鸣");
        student2.display();
    }
    
}