package target.multithreds;

public class Base {
    public static void main(String[] args) {
        //Its multithreaded execution with Time slices
        Thread t1 = new Thread(new Runner1()); //Extend from Thread
        Thread t2 = new Thread(new Runner2()); // Implements Runnable interface
        t1.start();
//        try {
//            t1.join(); // This will ensure next line executed only after completing t1
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        t2.start();
        //Anonymous Class
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Hi from Anonymous");
            }
        });

        //As Thread internally implements runnable
        Thread t4 = new Thread(() -> System.out.println("Hi from Lambda"));
        t3.start();
        t4.start();
    }
}

class Runner1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner1: "+i);
        }
        System.out.println("Thread t1 Finished");
    }
}

class Runner2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Runner2: "+i);
        }
    }
}

