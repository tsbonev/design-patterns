package com.clouway;

import com.clouway.singleton.Singleton;

public class Main {

    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();


    }
}
