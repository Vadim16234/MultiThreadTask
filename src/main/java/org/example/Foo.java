package org.example;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private final CountDownLatch cd1 = new CountDownLatch(1);
    private final CountDownLatch cd2 = new CountDownLatch(1);

    public void first() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("first");
            }
        });

        threadA.start();
        cd1.countDown();
    }

    public void second() {
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cd1.await();
                    System.out.print("second");
                    cd2.countDown();
                } catch (InterruptedException e) {
                    System.out.println("Поток прерван" + e);
                }
            }
        });
        threadB.start();
    }

    public void third() {
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cd2.await();
                    System.out.print("third");
                    cd2.countDown();
                } catch (InterruptedException e) {
                    System.out.println("Поток прерван" + e);
                }
            }
        });
        threadC.start();
    }
}
