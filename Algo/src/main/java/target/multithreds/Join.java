package target.multithreds;

public class Join {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                System.out.println("T1: "+i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 5; i < 10; i++){
                System.out.println("T2: "+i);
            }
        });
        t1.start();
        try {
            t1.join(); // To ensure sequence and it will hold everything until T1 returns
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
