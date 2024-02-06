package LeetCode;

public class PartitionArray {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(maxSumAfterPartitioning(arr,3));
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int result = 0 , n = arr.length;
        int i = 0 , j = 0 , max = 0;
        while (j < n){
            if (j-i < k){
                max = Math.max(max,arr[j]);
            }else {
                result += max;
                i++;
            }
            j++;
        }
        return  result;
    }
}
