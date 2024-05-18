package LeetCode;

public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd",'d'));
    }
    public static String reversePrefix(String word, char ch) {
        if(word.indexOf(ch) < 0){
            return word;
        }

        StringBuilder sb = new StringBuilder();
        int target = word.indexOf(ch);
        for (int i = target ; i >= 0 ; i--){
            sb.append(word.charAt(i));
        }
        for (int i = target+1 ; i < word.length() ; i++){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
