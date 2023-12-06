package prep.array;

public class Patterns {
    public static void main(String[] args) {
        print(5);
    }

    private static void print(int n){
        int temp = 1;
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j <=i ; j++){
                System.out.print(temp+++" ");
            }
            System.out.println(" ");
        }
    }
}
