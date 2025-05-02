package target.multithreds;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReentrantLock {
    public static void main(String[] args) {
        Worker worker = new Worker();
           Thread t1 = new Thread(() -> {
               try {
                   worker.produce();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           });

        Thread t2 = new Thread(() -> {
            try {
                worker.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}

class Worker{
    private Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method");
        condition.await();
        System.out.println("Producer method Again");
        lock.unlock();
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(2000); //To ensure Producer acquires the lock
        lock.lock();
        System.out.println("Consumer method");
        Thread.sleep(3000);
        condition.signal();
        lock.unlock();
    }
}
