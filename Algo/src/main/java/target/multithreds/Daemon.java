package target.multithreds;

public class Daemon {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Daemon is running");
            }
        });

        Thread normal = new Thread(() -> {
            System.out.println("Normal Thread is running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Normal Thread finished");
        });
        daemon.setDaemon(true);
        System.out.println(daemon.isDaemon());
        daemon.start();
        normal.start();
        try {
            normal.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread normal2 = new Thread(() -> {
            System.out.println("Normal Thread 2 is running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Normal Thread 2 finished");
        });
        normal2.start();
        //By the end of all normal execution, daemon will also be finished as no more worker threads left to be executed
    }
}
