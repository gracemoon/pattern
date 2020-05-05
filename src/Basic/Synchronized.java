package Basic;

public class Synchronized {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new AddTimes());
        thread1.start();
        Thread thread2 = new Thread(new SubstractTimes());
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Lock.count);
    }
}


class Lock{
    public static Lock lock=new Lock();
    public static int count=0;
}



class AddTimes implements Runnable{
    public void run() {
        synchronized(Lock.lock){
            for(int i=0;i<1000000;i++){
                Lock.count+=1;
            }
        }
        
        
    }
}


class SubstractTimes implements Runnable{
    public void run() {
        synchronized(Lock.lock){
            for(int i=0;i<1000000;i++){
                Lock.count-=1;
            }
        }
    }
}