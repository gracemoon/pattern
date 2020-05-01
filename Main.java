import Singleton.HungrySingleton;
public class Main {
    public static void main(String[] args) {
        HungrySingleton instance=HungrySingleton.getInstance();
        instance.printSentence();
    }
    
}