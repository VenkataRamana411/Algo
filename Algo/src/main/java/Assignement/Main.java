package Assignement;

public class Main {

    public static int countDigitOne(int N){
        if (N < 0 || N > 100){
            throw new RuntimeException("The Number is Not Valid");
        }
        int result = 0;
        for(int i = 1 ; i <= N; i++){
            int temp = 0;
            int curr = i;
            while (curr > 0) {
                if (curr % 10 == 1) {
                    temp++;
                }
                curr /= 10;
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(countDigitOne(11));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
