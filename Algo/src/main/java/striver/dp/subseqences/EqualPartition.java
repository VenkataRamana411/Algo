package striver.dp.subseqences;

public class EqualPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if (total % 2 != 0){
            return false;
        }
        total = total / 2;
        boolean[] dp = new boolean[total+1];
        if (nums[0] <= total) {
            dp[nums[0]] = true;
        }
        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[total+1];
            for (int j = 1; j <= total; j++){
                boolean noTake = dp[j];
                boolean take = false;
                if (nums[i] <= j){
                    take = dp[j-nums[i]];
                }
                curr[j] = take || noTake;
            }
            dp = curr;
        }
        return dp[total];
    }
}
