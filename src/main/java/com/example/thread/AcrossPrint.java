package com.example.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程交替打印
 */
public class AcrossPrint {

    private final Object monitor = new Object();
    private volatile int count = 0;

    private void print(int n, int current, int limit) {
        synchronized (monitor) {
            while (count <= limit) {
                if (count % n == current) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    monitor.notifyAll();
                    try {
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

    public void run(int nThreads, int limit) {
        for (int i = 0; i < nThreads; i++) {
            int finalI = i;
            new Thread(() -> print(nThreads, finalI, limit), "Thread" + i).start();
        }
    }

    public static void main(String[] args) {
        AcrossPrint ap = new AcrossPrint();
        ap.run(5, 100);
    }

}
