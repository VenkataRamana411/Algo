package designpatterns.behavioural.template;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Network network;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter\n1: Facebook \n2: Twitter ");
        int socialNetwork = scanner.nextInt();
        if (socialNetwork == 1){
            network = new Facebook();
        }else if (socialNetwork == 2){
            network = new Twitter();
        }else {
            throw new IllegalArgumentException("Please select from provided options");
        }
        System.out.println("Please enter username: ");
        String username = scanner.next();
        System.out.println("Please enter password: ");
        String password = scanner.next();
        System.out.println("Please enter message to post: ");
        String message = scanner.next();
        network.post(username,password,message);
    }
}
