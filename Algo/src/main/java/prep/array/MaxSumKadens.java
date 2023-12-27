package prep.array;

public class MaxSumKadens {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if (maximum < sum){
                maximum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return maximum;
    }
}
