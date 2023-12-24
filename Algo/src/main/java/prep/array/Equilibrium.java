package prep.array;

public class Equilibrium {
    public static void main(String[] args) {
        int[] nums = new int[]{-7, 1, 5, 2, -4, 3, 0};
        System.out.println(helper(nums));
        System.out.println(helper2(nums));
    }
/**
 *   0, 7, -6, 1, -1, 3, 0                     0
*   -7, 1,  5,  2, -4, 3, 0
 *  -7, -6, -1, 1, -3, 0, 0
* */
    private static int helper(int[] nums) {
        int result = -1;
        if (nums.length == 1 || nums.length == 0) {
            return nums.length - 1;
        }
        int total = 0;
        int[] prefix = new int[nums.length];
        prefix[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            prefix[i] = prefix[i+1] + nums[i];
        }
        for (int i = 0 ; i < nums.length-1 ; i++){
            if (total == prefix[i+1]){
                return i;
            }else {
                total += nums[i];
            }
        }
        return result;
    }
    private static int helper2(int[] nums) {
        int result = -1;
        if (nums.length == 1 || nums.length == 0) {
            return nums.length - 1;
        }
        int totalSum = 0,leftsum = 0;
        for (int i = 0; i < nums.length ; i++) {
            totalSum += nums[i];
        }
        for (int i = 0 ; i < nums.length ; i++){
            totalSum -= nums[i];
            if (leftsum == totalSum){
                return i;
            }else {
                leftsum += nums[i];
            }
        }
        return result;
    }
}
