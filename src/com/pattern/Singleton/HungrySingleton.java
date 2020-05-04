package com.pattern.Singleton;

public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){

    }
    public static HungrySingleton getInstance(){
        return instance;
    }
    private String sentence="hello world";
    public void printSentence(){
        System.out.println(this.sentence);
    }
}
