package org.example;

import java.util.concurrent.Semaphore;

public class SecondThread implements Runnable{
    Foo foo;
    Semaphore sem;

    SecondThread(Semaphore s, Foo f) {
        sem = s;
        this.foo = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            sem.acquire();
            foo.second();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        sem.release();
    }
}
