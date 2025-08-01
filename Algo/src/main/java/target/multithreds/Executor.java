package target.multithreds;

import java.util.concurrent.*;

public class Executor {
    public static void main(String[] args) {
        System.out.println("Single Thread Executor");
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 6; i++){
            service.execute(new Task(i));
        }
        service.shutdown();
        System.out.println("-------------------------------------------");
        System.out.println("Fixed Thread Executor");
        ExecutorService fixed = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 6; i++){
            fixed.execute(new Task(i));
        }
        fixed.shutdown();

        System.out.println("Cached Thread Executor");
        ExecutorService cached = Executors.newCachedThreadPool();
        for (int i = 1; i < 60; i++){
            cached.execute(new Task(i));
        }
        cached.shutdown();



        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(5);
        scheduled.scheduleAtFixedRate(new Task(411),1000,10000,TimeUnit.MILLISECONDS);
        //scheduled.shutdown(); // Prevent further tasks
        //To terminate running tasks
        try {
            if (!scheduled.awaitTermination(5000,TimeUnit.MILLISECONDS)){
                scheduled.shutdownNow(); //Stops all tasks after timeout
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            scheduled.shutdownNow();
        }

        ExecutorService executors = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++){
            Future<String> submit = executors.submit(new Processor1(i));
            try {
                System.out.println(submit.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
    }
}

class Task implements Runnable{

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id: "+id+" is in work - Thread ID: "+Thread.currentThread());
        long random = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Processor1 implements Callable<String> {

    private int id;

    public Processor1(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "ID: "+ id;
    }
}
