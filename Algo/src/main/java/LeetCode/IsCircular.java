package LeetCode;

public class IsCircular {

    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for(int i = 0, j = 1; j < n;i++,j++){
            if(words[i].charAt(words[i].length()-1) != words[j].charAt(0)){
                return false;
            }
        }
        return words[0].charAt(0) == words[n - 1].charAt(words[n - 1].length() - 1);
    }
}
