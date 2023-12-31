package designpatterns.behavioural.template;

public class Facebook extends Network{
    @Override
    boolean logIn(String userName, String password) {
        simulateNetworkLatency();
        System.out.println("User: " + userName + " logged into facebook");
        return true;
    }

    @Override
    boolean sendData(String message) {
        System.out.println("posting on facebook");
        return true;
    }

    @Override
    void logOut(String userName, String password) {
        System.out.println("User: " + userName + " logged out of facebook");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
            System.out.println();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
