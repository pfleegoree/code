package com.lil.spring_demo.singleton;

public class SingletonA {
    private static SingletonA instance;
    private SingletonA(){
        super();
    }
    public static SingletonA getInstance(){
        if (null == instance){
            synchronized (SingletonA.class){
                if(null == instance){
                   instance = new SingletonA();
                }
            }
        }
        return instance;
    }

}
