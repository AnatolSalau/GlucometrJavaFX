package com.work;

class Store {
    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                System.out.println("get wait");
                wait();

            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                System.out.println("put wait");
                wait();

            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
