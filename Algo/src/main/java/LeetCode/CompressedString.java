package LeetCode;

public class CompressedString {
    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaabcdeffe"));
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }

    public static String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ) {
            char c = word.charAt(i);
            int count = 1;
            while (++i < word.length()) {
                if (c == word.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
            while (count > 0) {
                int freq;
                if (count >= 9) {
                    freq = 9;
                    count -= 9;
                } else {
                    freq = count % 9;
                    count = 0;
                }
                sb.append(freq).append(c);
            }
        }
        return sb.toString();
    }
}
