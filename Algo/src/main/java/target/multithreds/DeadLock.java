package target.multithreds;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        //Lambda way to create and start thread
        new Thread(deadLock::worker1,"worker1").start();
        //new Thread(deadLock::worker2,"worker2").start();
        new Thread(deadLock::worker3,"worker3").start();
    }

    /**
     * DeadLock as threads waiting for each other to acquire each other locks
    * */
    public void worker1(){
        lock1.lock();
        System.out.println("Worker1 acquires the lock1 .....");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("Worker1 acquires the lock2 .....");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        lock2.lock();
        System.out.println("Worker2 acquires the lock2 .....");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.lock();
        System.out.println("Worker2 acquires the lock1 .....");
        lock2.unlock();
        lock1.unlock();
    }


    /**
     * If we define locks in same order it will avoid cyclic dependency, so it will execute without any problems
    * */
    public void worker3(){
        lock1.lock();
        System.out.println("Worker3 acquires the lock1 .....");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("Worker3 acquires the lock2 .....");
        lock1.unlock();
        lock2.unlock();
    }
}
