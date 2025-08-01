package target.multithreds;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchEx {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new DependentService(latch));
        service.submit(new DependentService(latch));
        service.submit(new DependentService(latch));

        latch.await();  // Wait till count reaches zero

        System.out.println("All Dependent services are initialized successfully");
        service.shutdown();
    }
}

class DependentService implements Runnable{

    private CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        latch.countDown();  //Decrement count by 1
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executed by : "+Thread.currentThread());
    }
}
