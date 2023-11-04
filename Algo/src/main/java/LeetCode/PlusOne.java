package LeetCode;

public class PlusOne {
    public static void main(String[] args) {
            int[] nums = new int[]{1,2,3};
            plusOne(nums);
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i++) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
            }
        }
        return digits;
    }
}
