package org.example;

import java.util.concurrent.CountDownLatch;

public class Foo implements Runnable {
    private final CountDownLatch cd1 = new CountDownLatch(1);
    private final CountDownLatch cd2 = new CountDownLatch(1);

    public void first() {
        new Thread();
        System.out.print("first");
        cd1.countDown();
    }

    public void second() {
        new Thread();

        try {
            cd1.await();
            System.out.print("second");
            cd2.countDown();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван" + e);
        }
    }

    public void third() {
        new Thread();

        try {
            cd2.await();
            System.out.print("third");
            cd2.countDown();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван" + e);
        }
    }

    @Override
    public void run() {
    }
}
