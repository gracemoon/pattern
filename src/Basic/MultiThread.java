package Basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThread {
    public static void main(String[] args) {
        CountTime countTime=new CountTime("thread count time");
        countTime.start();

        Thread thread=new CountTime("thread");
        thread.start();

        PrintCount printCount=new PrintCount("print count");
        printCount.run();

        Runnable runnable=new PrintCount("runnable");
        runnable.run();
        Callable<Integer> callable = new PrintTime();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        
        try {
            futureTask.run();
            System.out.println("feature count is = "+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }
}

class PrintTime implements Callable<Integer>{
    private int count=0;
    public Integer call() throws Exception {
        while(this.count<10){
            Thread.sleep(200);
            System.out.println(this.count++);
        }
        return count;
    }
    
}

class PrintCount implements Runnable{
    private int count=0;
    private String info;
    public PrintCount(String info){
        this.info=info;
    }
    public void run() {
        try {
            while(this.count<10){
                Thread.sleep(200);
                System.out.println(this.info+this.count++);
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}


class CountTime extends Thread {
    private int count=0;
    private String info;
    public CountTime(String info){
        this.info=info;
    }
    public void run() {
        try {
            while(this.count<50){
                Thread.sleep(200);
                System.out.println(this.info+this.count++);
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}