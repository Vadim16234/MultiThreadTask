package org.example;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        CompletableFuture.runAsync(() -> foo.third());
        CompletableFuture.runAsync(() -> foo.first());
        CompletableFuture.runAsync(() -> foo.second());
    }
}