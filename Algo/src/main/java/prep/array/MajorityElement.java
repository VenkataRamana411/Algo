package prep.array;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    /**
    * TC: O(N)
     * SC: O(1)
    * */
    public static int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        /** Bayer-Moore Algo - Introduced for presidential election result
        * If Count is more than half of the elements in an array we will always end up with Majority element
        * */
        for(int i = 1 ; i < nums.length ; i++){
            if (count == 0){
                majority = nums[i];
                count = 1;
            }else if (nums[i] == majority){
                count++;
            }else {
                count--;
            }
        }
        return majority;
    }
}
