package target.multithreds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++){
            int finalI = i;
            service.execute(() -> {
                Downloader.INSTANCE.download(finalI);
            });
        }
        service.shutdown();
    }
}


//Singleton
enum Downloader {
    INSTANCE;
    private Semaphore semaphore = new Semaphore(2,true);
    public void download(int counter){
        try {
            semaphore.acquire();
            downloader(counter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private void downloader(int counter){
        try {
            System.out.println("Downloading from web... "+counter);
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
