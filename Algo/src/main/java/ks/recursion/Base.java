package ks.recursion;

public class Base {
    public static void main(String[] args) {
        numberExample(1);
    }
    static void numberExample(int n){
        if (n > 5){
         return;
        }
        System.out.println(n);
        numberExample(++n);
    }
}
