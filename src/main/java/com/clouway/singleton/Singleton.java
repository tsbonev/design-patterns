package com.clouway.singleton;

public class Singleton {


    private static Singleton instance;

    public static Singleton getInstance(){

        if(instance == null) instance = new Singleton();

        return instance;

    }

    private Singleton(){
        System.out.println("Singleton created");
    }

}
