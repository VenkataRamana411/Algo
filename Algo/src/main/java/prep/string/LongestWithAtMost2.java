package prep.string;

import java.util.HashSet;
import java.util.Set;

public class LongestWithAtMost2 {
    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstringTwoDistinct("eceba",2));
        System.out.println(optimalApproach("eceba",2));
    }

    /**
     * TC:O(N)
     * SC: O(128)
    * */
    private static int optimalApproach(String s,int k){
        int result = 0 , left = 0 , right = 0 , uniqueCharCount = 0 , n = s.length();
        //Frequency Array
        int[] freq = new int[128];
        while (right < n){
            //Checking if current char frequency is 0
            //Incrementing char frequency and right pointer
            if (freq[s.charAt(right++)]++ == 0){
                uniqueCharCount++;
                //To check unique chars are with in the limit
                while (uniqueCharCount > k){
                    // Decreasing the frequency of char and incrementing left pointer to check if we completely removed required chars
                    if (--freq[s.charAt(left++)] == 0){
                        uniqueCharCount--;
                    }
                }
            }
            result = Math.max(result,right-left);
        }
        return result;
    }


   /* public static int lengthOfLongestSubstringTwoDistinct(String s,int k) {
   //NW
        int result = 0;
        Set<Character> chars = new HashSet<>();
        int i = 0 , j = 0;
        for(; j < s.length() ; j++){
            chars.add(s.charAt(j));
            if (chars.size() <= k){
                result = Math.max(result,j-i);
                int idx = s.substring(i, j).lastIndexOf(s.charAt(i))+1;
                for (; i < idx; i++) {
                    chars.remove(s.charAt(i));
                }
            }
        }
        return Math.max(result,j-i);
    }*/
}
