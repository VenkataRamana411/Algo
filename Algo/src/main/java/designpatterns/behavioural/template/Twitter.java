package designpatterns.behavioural.template;

public class Twitter extends Network{
    @Override
    boolean logIn(String userName, String password) {
        System.out.println("User: " + userName + " logged into Twitter");
        return true;
    }

    @Override
    boolean sendData(String message) {
        System.out.println("Posted on Twitter");
        return true;
    }

    @Override
    void logOut(String userName, String password) {
        System.out.println("User: " + userName + " logged out of Twitter");
    }
}
