package org.example;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private final CountDownLatch cd1 = new CountDownLatch(1);
    private final CountDownLatch cd2 = new CountDownLatch(1);

    public void first() {
        System.out.print("first");
        cd1.countDown();
    }

    public void second() throws InterruptedException {
        cd1.await();
        System.out.print("second");
        cd2.countDown();
    }

    public void third() throws InterruptedException {
        cd2.await();
        System.out.print("third");
        cd2.countDown();
    }
}
