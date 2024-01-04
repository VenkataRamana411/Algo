package prep.array;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{5,6,5,6,8}));
    }
    /**
     * TC: O(N)
     * SC: O(1)
    * */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums){
            result ^= n;
        }
        return result;
    }
}
