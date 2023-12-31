package designpatterns.behavioural.template;

public abstract class Network {
    private String userName;
    private String password;

    public Network() {
    }

    public void post(String userName,String password,String data){
        if (logIn(userName,password)){
            if (sendData(data)){
                System.out.println("Message posted successfully");
            }else {
                System.out.println("Error occurred while posting the Message");
            }
            logOut(userName,password);
        }else {
            System.out.println("User is Not authenticated");
        }
    }


    abstract boolean logIn(String userName,String password);
    abstract boolean sendData(String message);
    abstract void logOut(String userName,String password);
}
