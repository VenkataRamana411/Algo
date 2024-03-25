package prep.hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
    }
    /**
     * TC: O(N)
     * SC: O(Words) + O(Banned)
    *
    * */

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String s : banned){
            sb.append(s).append(" ");
        }
        String bannedStrings = sb.toString();
        String[] splitParagraph = paragraph.split("\\W+");
        for (String s : splitParagraph){
            String wordInLowercase = s.toLowerCase();
            if (!bannedStrings.contains(wordInLowercase)){
                hashMap.put(wordInLowercase,hashMap.getOrDefault(wordInLowercase,0)+1);
            }
        }
        return Collections.max(hashMap.entrySet(),Map.Entry.comparingByValue()).getKey();
        /*int max_Count = 0;
        String result = "";
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if (max_Count < entry.getValue()){
                max_Count = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;*/
    }
}
