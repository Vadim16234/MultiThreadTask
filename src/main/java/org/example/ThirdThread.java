package org.example;

import java.util.concurrent.Semaphore;

public class ThirdThread implements Runnable {
    Foo foo;
    Semaphore sem;

    ThirdThread(Semaphore s, Foo f) {
        sem = s;
        foo = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            sem.acquire();
            foo.third();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        sem.release();
    }
}
