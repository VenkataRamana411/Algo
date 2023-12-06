package LeetCode;

public class GoodNumber {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
    }

    public static String largestGoodInteger(String num) {
        int largest = -1 , temp = 1 , index = 0;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i - 1) == num.charAt(i)) {
                temp++;
            } else {
                temp = 1;
            }
            if (temp == 3) {
                int goodNumber = num.charAt(i);
                if (goodNumber > largest){
                    index = i;
                    largest = goodNumber;
                }
                temp = 1;
            }
        }
        if (largest != -1){
            return num.substring(index - 2, index+1);
        }
        return "";
    }
}
