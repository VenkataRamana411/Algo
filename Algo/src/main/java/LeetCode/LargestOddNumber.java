package LeetCode;

public class LargestOddNumber {
    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        System.out.println(largestOddNumber.largestOddNumber("5"));
    }

    public String largestOddNumber(String num) {
        String result = "";
        for (int i = num.length()-1; i >= 0; i--) {
            if (isOdd(num.charAt(i))) {
                return num.substring(0, i+1);
            }
        }
        return result;
    }

    private boolean isOdd(char c) {
        return c == '1' || c == '3' || c == '5' || c == '7' || c == '9';
    }
}
