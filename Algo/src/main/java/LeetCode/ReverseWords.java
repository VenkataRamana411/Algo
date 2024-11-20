package LeetCode;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i > 0; i--) {
            if(!str[i].equals("")){
                sb.append(str[i]).append(" ");
            }
        }
        if(!str[0].equals("")){
            sb.append(str[0]);
        }
        s.trim();
        return sb.toString().trim();
    }
}
