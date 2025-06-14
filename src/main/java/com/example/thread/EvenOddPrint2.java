package com.example.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrint2 {

    private final ReentrantLock lock;
    private final Condition condition;

    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    private final AtomicInteger num = new AtomicInteger(0);

    private void print(boolean isOdd, int limit) {
        lock.lock();
        try {
            while (num.get() <= limit) {
                if ((isOdd && num.get() % 2 == 1) || (!isOdd && num.get() % 2 == 0)) {
                    System.out.println(Thread.currentThread().getName() + ": " + num.getAndIncrement());
                    condition.signalAll();
                }
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public void run(int limit) {
        new Thread(() -> print(false, limit)).start();
        new Thread(() -> print(true, limit)).start();
    }

    private void printAB(String s) {
        lock.lock();
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": " + s);
                condition.signalAll();
                TimeUnit.SECONDS.sleep(1);
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private void run2() {
        new Thread(() -> printAB("A")).start();
        new Thread(() -> printAB("B")).start();
    }

    public static void main(String[] args) {
//        new EvenOddPrint2().run(40);
        new EvenOddPrint2().run2();
    }
}
