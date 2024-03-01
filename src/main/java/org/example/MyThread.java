package org.example;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable{
    private final CountDownLatch latch;

    MyThread(CountDownLatch c) {
        latch = c;
        new Thread(this).start();
    }

    public void run() {
    }
}
