package com.work;

public class Program {

    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        System.out.println("producer started");
        new Thread(consumer).start();
        System.out.println("consumer started");
    }
}
