package LeetCode;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        System.out.println(bagOfTokensScore(tokens,200));
        System.out.println(bagOfTokensScore(new int[]{100},50));
        System.out.println(bagOfTokensScore(new int[]{200,100},150));
        System.out.println(bagOfTokensScore(new int[]{},150));
        System.out.println(bagOfTokensScore(new int[]{71,55,82},54));
    }
    public static int bagOfTokensScore(int[] tokens, int power) {
        int currScore = 0,maxScore = 0;
        Arrays.sort(tokens);
        int i = 0 , j = tokens.length-1;
        while (i <= j){
            if (power >= tokens[i]){
                currScore++;
                power -= tokens[i++];
            }else if (currScore < 1){
                break;
            }else {
                power += tokens[j--];
                if (j < i){
                    break;
                }
                maxScore = Math.max(maxScore, currScore--);
            }
        }
        return Math.max(maxScore, currScore);

    }
}
