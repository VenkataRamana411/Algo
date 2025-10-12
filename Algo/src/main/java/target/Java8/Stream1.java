package target.Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,45,6,5,4,4,545,487,1,485,47);
        list.stream().filter(a -> a % 2 == 0).forEach(s -> System.out.print(" "+s));
        System.out.println();
        System.out.println("----------");
        //Max
        Optional<Integer> optionalMax = list.stream().max(Comparator.comparingInt(a -> a));  //list.stream().max(Integer::compareTo);
        System.out.println(optionalMax.get());
        //Sum
        System.out.println(list.stream().reduce(0, (a, b) -> a + b)); //Identity is initial Value
        System.out.println(list.stream().mapToInt(a->a).sum());
        //Sort
        System.out.println(list.stream().sorted().collect(Collectors.toList()));  //sorted(Comparator.reverseOrder()) - For Descending
        //Count
        System.out.println(list.stream().filter(e -> e > 5).count());
        //Distinct
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        //Return Any
        System.out.println(list.stream().findAny().get());
        //find first
        System.out.println(list.stream().findFirst().get());
        //AllMatch
        System.out.println(list.stream().allMatch(e -> e > 0));
        //None Match
        System.out.println(list.stream().noneMatch(e -> e == 1000));
        //Limit
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
        //Skip
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(3).collect(Collectors.toList()));
        //Skip
        System.out.println(list.stream().filter(e -> e % 2 != 0).collect(Collectors.toCollection(() -> new TreeSet<>())));   //System.out.println(new TreeSet<>(list));
        //FlatMap
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1,2),Arrays.asList(2,3,4,5));
        System.out.println(nestedList.stream().flatMap(e -> e.stream()).collect(Collectors.toList()));  //flatMap(List::stream)
        //UpperCase
        List<String> stringList = List.of("venkata b","ramana b","bandela");
        List<String> upperCaseList = stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());//map(String::toUpperCase)
        System.out.println(upperCaseList);
        //First Name Extraction
        System.out.println(stringList.stream().map(s -> s.split(" ")[0]).collect(Collectors.toList()));  //[0] ensures First element out of split array

        //Peek
        System.out.println(list.stream().filter(e -> e == 4).peek(System.out::println).count());

        //SummaryStatistics
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(a -> a).summaryStatistics();
        System.out.println(intSummaryStatistics.toString());

    }
}
