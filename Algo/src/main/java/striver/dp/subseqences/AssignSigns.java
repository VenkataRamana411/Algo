package striver.dp.subseqences;

public class AssignSigns {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(helper(nums,3,nums.length-1));
    }

    private static int helper(int[] nums,int target,int index){
        if (index == 0){
            if (target-nums[index] == 0 || target + nums[index] == 0){
                return 1;
            }
            return 0;
        }
        return helper(nums,target-nums[index],index-1) + helper(nums,target+nums[index],index-1);
    }

}
