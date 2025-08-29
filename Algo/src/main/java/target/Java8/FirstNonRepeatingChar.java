package target.Java8;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println(helper("swwiissz"));
        System.out.println(helper8("swiissz"));
    }

    private static char helper(String input) {
        int[] freqArray = new int[26];
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            freqArray[c - 'a']++;
        }

        for (char c : charArray) {
            if (freqArray[c - 'a'] == 1) {
                return c;
            }
        }
        return '0';
    }


    //.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))  We can provide our own map if needed
    private static char helper8(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse('0');


    }

    private static char helper2(String input){
        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(character -> input.indexOf(character) == input.lastIndexOf(character))
                .findFirst()
                .orElse('0');
    }
}
