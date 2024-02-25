package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Semaphore sem = new Semaphore(1);

        new FirstThread(sem, foo);
        new SecondThread(sem, foo);
        new ThirdThread(sem, foo);
    }
}