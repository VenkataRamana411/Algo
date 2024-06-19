package LeetCode;

public class ContiSubArray {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{23,2,6,4,7},13,0,0,0));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        return helper(nums,k,0,0,0);
    }
    private static boolean helper(int[] nums,int k,int index,int sum,int len){
        if(nums.length == index){
            return false;
        }
        if(len > 1 && sum % k == 0){
            return true;
        }
        //sum += nums[index];
        //len++;
        return helper(nums,k,index+1,sum+nums[index],len++) || helper(nums,k,index+1,sum,len);
        // sum -= nums[index];
        // len--;
        // helper(nums,k,index+1,sum,len);

    }
}
