package target.Java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "This is Ramana";
        helper1(sentence);
        optimizedHelper(sentence);
        streamHelper(sentence);
    }

    private static void helper1(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void optimizedHelper(String sentence) {
        int n = sentence.length();
        StringBuilder result = new StringBuilder(n);
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || sentence.charAt(end) == ' ') {
                for (int i = end - 1; i >= start; i--) {
                    result.append(sentence.charAt(i));
                }
                if (end < n) {
                    result.append(" ");
                }
                start = end + 1;
            }
        }
        System.out.println(result);
    }

    private static void streamHelper(String sentence) {
        String result = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(result);

    }
}
