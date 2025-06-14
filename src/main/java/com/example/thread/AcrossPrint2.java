package com.example.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AcrossPrint2 {

    private final ReentrantLock lock;
    private final Condition condition;
    private final AtomicInteger count = new AtomicInteger(0);

    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    private void print(int nThreads, int currentThread, int limit) {
        lock.lock();
        try {
            while (count.get() <= limit) {
                if (count.get() % nThreads == currentThread) {
                    System.out.println(Thread.currentThread().getName() + ": " + count.getAndIncrement());
                    condition.signalAll();
                }
                condition.await();
            }
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public void run(int nThreads, int limit) {
        for (int i = 0; i < nThreads; i++) {
            int finalI = i;
            new Thread(() -> print(nThreads, finalI, limit), "Thread-" + i).start();
        }
    }

    public static void main(String[] args) {
        new AcrossPrint2().run(3, 30);
    }

}
