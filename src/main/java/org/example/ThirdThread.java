package org.example;

import java.util.concurrent.Semaphore;

public class ThirdThread implements Runnable {
    private final Foo foo;
    private final Semaphore sem;

    ThirdThread(Semaphore s, Foo f) {
        sem = s;
        this.foo = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            sem.acquire();
            foo.third();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        sem.release();
    }
}
