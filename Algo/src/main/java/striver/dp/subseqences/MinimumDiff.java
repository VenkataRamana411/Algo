package striver.dp.subseqences;

public class MinimumDiff {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {3,1,5,2,8};
//        int total = 0;
//        for (int n : nums){
//            total += n;
//        }
//        //helper(nums,nums.length,0,0,total);
//        int[][][] dp = new int[nums.length][total+1][total+1];
//
//        helperMemo(nums,nums.length,0,0,total,dp);
        System.out.println(helperTab(nums,nums.length));
    }

    public static int helperTab(int[] nums,int n){
        int total = 0;
        for(int num : nums){
            total += num;
        }
        boolean[][] dp = new boolean[n][total+1];
        //For Every index target 0 is achievable if we are not picking anything
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if (nums[0] >= total){
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= total; j++){
                boolean noTake = dp[i-1][j];
                boolean take = false;
                if (nums[i] <= j){
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take || noTake;
            }
        }
        //DP ideally have answer for every target at last row
        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= total; j++){
            if (dp[n-1][j]){
                result = Math.min(result,Math.abs(j-(total-j)));
            }
        }
        return result;
    }

    public static void helper(int[] nums,int n,int index,int ls,int rs) {
        if(index == n){
            min = Math.min(min,Math.abs(ls-rs));
            return;
        }
        helper(nums,n,index+1,ls+nums[index],rs-nums[index]);
        helper(nums,n,index+1,ls,rs);
    }

    public static void helperMemo(int[] nums,int n,int index,int ls,int rs,int[][][] dp) {
        if(index == n){
            min = Math.min(min,Math.abs(ls-rs));
            return;
        }
        if (dp[index][ls][rs] != -1){
            return;
        }
        helper(nums,n,index+1,ls+nums[index],rs-nums[index]);
        helper(nums,n,index+1,ls,rs);
        dp[index][ls][rs] = min;
    }
}
