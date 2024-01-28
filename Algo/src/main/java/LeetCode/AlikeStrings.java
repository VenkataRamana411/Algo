package LeetCode;

public class AlikeStrings {
    public static void main(String[] args) {
        AlikeStrings alikeStrings = new AlikeStrings();
        System.out.println(alikeStrings.halvesAreAlike("textbook"));
    }

    public boolean halvesAreAlike(String s) {
        int count1 = 0 , count2 = 0;
        for(int i = 0 , j = s.length()-1 ; i < j ; i++,j--){
            count1 += isVowel(s.charAt(i));
            count2 += isVowel(s.charAt(j));
        }
        return count1 == count2;
    }
    private int isVowel(Character c){
        if (c == 'a' || c == 'e' || c == 'i' || c== 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c== 'O' || c == 'U'){
            return 1;
        }
        return 0;
    }
}
