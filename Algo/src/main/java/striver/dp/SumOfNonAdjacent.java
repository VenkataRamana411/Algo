package striver.dp;

public class SumOfNonAdjacent {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,3,5,8,1,9};
        System.out.println(helper(nums,0));
    }

    private static int helper(int[] nums,int index){
        if (index >= nums.length){
            return 0;
        }
        int t1 = nums[index] + helper(nums,index+2);
        int t2 = nums[index] + helper(nums,index+3);
        return Math.max(t1,t2);
    }

    private static int helper2(int[] nums,int index){
        if (index == 0){
            return nums[0];
        }
        if (index < 0){
            return 0;
        }
        int pick = nums[index] + helper2(nums,index-2);
        int noPick = 0 + helper2(nums,index-1);
        return Math.max(pick,noPick);
    }

    private static int spaceOptimized(int[] nums){
        int n = nums.length, prev = nums[0],prev2 = 0;
        for (int i = 1 ; i < n; i++){
            int take = nums[i];
            if (i > 1){
                take += prev2;
            }
            int noTake = 0 + prev;
            prev2 = prev;
            prev = Math.max(take,noTake);
        }
        return prev;
    }

}
