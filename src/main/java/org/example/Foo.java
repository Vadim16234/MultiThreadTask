package org.example;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private final CountDownLatch cd1 = new CountDownLatch(1);
    private final CountDownLatch cd2 = new CountDownLatch(1);

    public void first() {
        new MyThread(cd1);
        System.out.print("first");
        cd1.countDown();
    }

    public void second() {
        new MyThread(cd1);

        try {
            cd1.await();
            System.out.print("second");
            cd2.countDown();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван" + e);
        }
    }

    public void third() {
        new MyThread(cd2);

        try {
            cd2.await();
            System.out.print("third");
            cd2.countDown();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван" + e);
        }
    }
}
