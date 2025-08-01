package target.multithreds;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierEx {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Task1(barrier));
        service.submit(new Task1(barrier));
        service.submit(new Task1(barrier));

        Thread.sleep(5000);
        service.shutdownNow(); //To stop all running tasks
    }
}

class Task1 implements Runnable{
    private CyclicBarrier barrier;

    public Task1(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while (true){
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Executed!!! "+Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
