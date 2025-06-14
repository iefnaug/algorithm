package com.example.thread;

public class EvenOddPrint {

    private final Object monitor = new Object();
    private volatile int num = 0;

    private void print(boolean isOdd, int limit) {
        synchronized (monitor) {
            while (num <= limit) {
                if ((isOdd && num % 2 == 1) || (!isOdd && num % 2 == 0)) {
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    try {
                        monitor.notifyAll();
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            monitor.notifyAll();
        }
    }

    public void run(int limit) {
        new Thread(() -> print(true, limit), "t1").start();
        new Thread(() -> print(false, limit), "t2").start();
    }


    public static void main(String[] args) {
        new EvenOddPrint().run(50);
    }
}
