package prep.array.assign;

public class RangeSumQuery {
    int[] nums = null;
    int[] prefix = null;
    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
    }

    /**
     * -2, 0, 3, -5, 2, -1
     * -2, -2,1, -4, -2, -3
     *
    * */
    public int sumRange(int left, int right) {
        if (left == 0){
            return prefix[right];
        }
        return prefix[right]-prefix[left-1];
    }
}
