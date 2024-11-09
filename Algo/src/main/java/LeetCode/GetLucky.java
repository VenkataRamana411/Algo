package LeetCode;

public class GetLucky {
    public static void main(String[] args) {
        System.out.println('a' - 'a' + 1);
        System.out.println(getLucky("leetcode", 2));
    }

    public static int getLucky(String s, int k) {
        int result = 0;
        for (char c : s.toCharArray()) {
            int temp = c - 'a' + 1;
            if (temp > 9) {
                temp = (temp / 10) + (temp % 10);
            }
            result += temp;
        }
        k--;
        while (k != 0) {
            int temp = 0;
            while (result > 0) {
                temp += result % 10;
                result /= 10;
            }
            k--;
            result = temp;
        }
        return result;
    }
}
