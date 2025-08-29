package target.Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblems {
    public static void main(String[] args) {
        //countChars("Programmer Ramana");
    }

    private static void countChars(String input) {
        //Traditional Way

        Map<Character, Integer> freqMap1 = new HashMap<>();
        for (Character c : input.toCharArray()) {
            freqMap1.put(c, freqMap1.getOrDefault(c, 0) + 1);
        }

        //Traditional Way - 2
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character c : input.toCharArray()) {
            freqMap.merge(c, 1, Integer::sum);  //freqMap.merge(c,1, (v1,v2) -> v1+v2));
        }
        System.out.println(freqMap);


        //Optimal Way : Convert to int then chars

        Map<Character, Long> output1 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(output1);


        //Costlier due to creation of multiple strings

        Map<String, Long> collectOutput = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collectOutput);


        // High performance
        ConcurrentMap<Character, Long> collectParallel = input.chars()
                .parallel()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingByConcurrent(c -> c, Collectors.counting()));
        System.out.println(collectOutput);

        String s = "This is name name";
        Map<String, Long> collect = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(collect);
    }

    private static void firstNonRepeatChar(String input){

    }
}
