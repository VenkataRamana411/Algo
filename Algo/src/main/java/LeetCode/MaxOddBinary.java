package LeetCode;

public class MaxOddBinary {
    public static void main(String[] args) {

    }

    public String maximumOddBinaryNumber(String s) {
        int zeroCount = 0 , oneCount = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (oneCount-- != 1) {
            sb.append("1");
        }
        while (zeroCount-- != 0) {
            sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}
