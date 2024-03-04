package org.example;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        CompletableFuture.runAsync(() -> {
            try {
                foo.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture.runAsync(() -> foo.first());
        CompletableFuture.runAsync(() -> {
            try {
                foo.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(1000);
    }
}