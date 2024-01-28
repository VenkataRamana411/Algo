package prep.array;

public class MaxOne1 {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes2(new int[]{1,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        int result = 0 , count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        return Math.max(result, count);
    }
}
