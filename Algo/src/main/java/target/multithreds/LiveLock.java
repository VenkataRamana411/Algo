package target.multithreds;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LiveLock deadLock = new LiveLock();
        //Lambda way to create and start thread
        new Thread(deadLock::worker1,"worker1").start();
        new Thread(deadLock::worker2,"worker2").start();
        //new Thread(deadLock::worker3,"worker3").start();
    }

    /**
     * DeadLock as threads waiting for each other to acquire each other locks
    * */
    public void worker1(){
        while (true){
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker1 acquires the lock1 .....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker1 try to acquire lock2 .....");
            if (lock2.tryLock()){
                System.out.println("Worker1 acquires the lock2 .....");
                lock1.unlock();
            }else {
                System.out.println("Worker1 is waiting for lock2 !!!!");
            }
        }

    }

    public void worker2(){
        while (true){
            try {
                lock2.tryLock(60, TimeUnit.MILLISECONDS);
                System.out.println("Worker2 acquires the lock2 .....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker2 try to acquire lock1 .....");
            if (lock1.tryLock()){
                System.out.println("Worker2 acquires the lock1 .....");
                lock2.unlock();
            }else {
                System.out.println("Worker2 is waiting for lock1 !!!!");
            }
        }
    }

}
