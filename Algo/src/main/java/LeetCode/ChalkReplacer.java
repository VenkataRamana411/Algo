package LeetCode;

public class ChalkReplacer {
    public static void main(String[] args) {
        int[] nums = {3,4,1,2};
        System.out.println(chalkReplacer(nums,8));
    }
    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int num : chalk){
            sum += num;
        }
        int rem = (int) (k % sum);
        for(int i = 0 ; i < chalk.length; i++){
            if(rem-chalk[i] < 0){
                return i;
            }
            rem -= chalk[i];
        }
        return -1;
    }
}
