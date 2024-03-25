package LeetCode;

public class BinarySubArraySum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0, currSum = 0, prefixZeros = 0, result = 0;
        for (int end = 0; end < nums.length; end++) {
            currSum += nums[end];
            while (start < end && (nums[start] == 0 || currSum > goal)){
                if (nums[start] == 0){
                    prefixZeros++;
                }else {
                    prefixZeros = 0;
                }
                currSum -= nums[start++];
            }
            if (currSum == goal){
                result += 1 + prefixZeros;
            }
        }
        return result;
        /*int result = nums[0] == goal ? 1 : 0;
        int windowSum = nums[0], i = 0, j = 1;
        if (nums.length == 1) {
            return result;
        }
        while (i < j) {
            if (j == nums.length) {
                if (windowSum == goal) {
                    result++;
                }
                windowSum -= nums[i++];
            } else {
                int tempSum = windowSum + nums[j];
                if (nums[j] == goal) {
                    result++;
                }
                if (tempSum < goal) {
                    windowSum = tempSum;
                    j++;
                } else if (tempSum > goal) {
                    windowSum -= nums[i++];
                } else {
                    result++;
                    windowSum = tempSum;
                    j++;
                }
            }
        }
        return result;*/
    }
}
