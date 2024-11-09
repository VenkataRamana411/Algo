package LeetCode;

public class MinimumSteps {
    public static void main(String[] args) {
        System.out.println(minimumSteps("100"));
    }

    public static long minimumSteps(String s) {
        long result = 0;
        int blackCount = 0;
        for(int i = 0 ; i < s.length(); i++){
            // Swap with all black balls to its left
            if(s.charAt(i) == '0'){
                result += (long) blackCount;
            }else{
                blackCount++;
            }
        }
        return result;
        //        long result = 0;
//        char[] balls = s.toCharArray();
//        int n = balls.length;
//        for(int i = 0 , j = n - 1; i < j;){
//            if(balls[i] == '0'){
//                i++;
//            }else{
//                while(balls[j] != '0'){
//                    j--;
//                }
//                result++;
//                balls[i++] = '0';
//                balls[j--] = '1';
//            }
//        }
//        return result;
    }
}
