package org.example;

import java.util.concurrent.Semaphore;

public class FirstThread implements Runnable{
    Foo foo;
    Semaphore sem;

    FirstThread(Semaphore s, Foo f) {
        sem = s;
        foo = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            sem.acquire();
            foo.first();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        sem.release();
    }
}