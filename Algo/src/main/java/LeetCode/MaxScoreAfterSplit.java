package LeetCode;

public class MaxScoreAfterSplit {
    public static void main(String[] args) {
        System.out.println(maxScore("00111"));
    }
    public static int maxScore(String s) {
        int ans = 0 , zero = 0 , one = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                zero++;
            }else{
                one++;
            }
        }
        for(int i = s.length()-1 ; i >= 0 ; i--){
            if(s.charAt(i) == '0'){
                zero--;

            }else{
                one--;
            }
            if(ans < (zero + one)){
                ans = zero + one;
            }
        }
        return ans;
    }
}
