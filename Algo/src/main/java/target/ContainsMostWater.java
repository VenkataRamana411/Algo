package target;

public class ContainsMostWater {
    public static void main(String[] args) {
        int[] heights ={3,4,1,2,2,4,1,3,2};
        System.out.println(helper(heights));
        System.out.println(helper(new int[]{1,2,1}));
    }

    /**
     * TC: O(N)
     * SC: O(1)
    * */
    private static int helper(int[] heights){
        int left = 0, right = heights.length-1;
        int result = 0;
        // Take two pointers and move the pointers according to the greater value to ensure max storage
        while (left < right){
            if (heights[left] > heights[right]){
                result = Math.max(result,(right-left)*heights[right]);
                right--;
            }else {
                result = Math.max(result,(right-left)*heights[left]);
                left++;
            }
        }
        return result;
    }
}
