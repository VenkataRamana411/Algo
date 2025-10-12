package target.Java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayFrequency {
    public static void main(String[] args) {
        helper();
    }

    private static void helper(){
        int[] arr = {4,5,6,5,4,3,6,4,6,5};
        Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(a->a,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())   //.sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())  Need Generic type for reverse
                .forEach(System.out::println);
        List<String> list = List.of("Ram","Venkata","Ram");
        List<String> collect1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);
        String input = "ramana";
        Map<String, Long> collect = Arrays.stream(input.split(""))              //.map(String::toLowerCase)
                .collect(Collectors.groupingBy(c -> c, () -> new LinkedHashMap<>(),Collectors.counting()));  //LinkedHashMap::new
        System.out.println(collect);
    }
}
