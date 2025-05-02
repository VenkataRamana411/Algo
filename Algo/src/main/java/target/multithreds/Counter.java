package target.multithreds;

public class Counter {
    public static int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 100; i++){
               incrementCounter();
           }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                incrementCounter();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter);
    }

    private static synchronized void incrementCounter(){
        counter++;
    }
}
