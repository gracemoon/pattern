package Basic;

public class UnsafeSequence {
    public static void main(String[] args) throws InterruptedException {
        Sequence sequence=new Sequence(0);
        Thread thread1=new Thread(sequence);
        thread1.start();
        Thread thread2=new Thread(sequence);
        thread2.start();
        thread1.join();
        thread2.join();
        sequence.getValue();
    }
}

class Sequence implements Runnable {
    private int value;

    public Sequence(int value) {
        this.value = value;
    }

    public synchronized void getNext() {
        this.value++;        
    }

    public void getValue(){
        System.out.println(this.value);
    }

    public void run() {
        try {
            int i=0;
            while(i<10000){
                i++;
                this.getNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}