package target.Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 25, 30, 100, 25, 200);
        list.stream().map(s -> s.toString()).filter(s -> s.startsWith("1")).forEach(System.out::println);
        //list.stream().map(s-> s.toString()).filter(s -> s.startsWith("1")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());  // map(Integer::parseInt)
        //Cubes
        list.stream().map(i -> i * i * i).filter(i -> i < 500).forEach(System.out::println);

        //Duplicate Elements
        Set<Integer> hashSet = new HashSet<>();
        System.out.println(list.stream().filter(s -> !hashSet.add(s)).collect(Collectors.toList()));
        //Alternative Way
        list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(entry -> entry.getKey())   //.map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //Find First element
        list.stream().findFirst().ifPresent(System.out::println);

        //Count Strings
        List<String> strings = List.of("AA","BB","CC","AA");
        Map<String, Long> collect = strings.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(collect);
        List<String> duplicatedList = strings.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

        Optional.ofNullable(duplicatedList).orElseGet(Collections::emptyList).forEach(System.out::println);  // Check if not null then iterate

        //Way to use array input
        Arrays.stream(new int[]{20, 3, 654, 55, 4})
                .boxed()
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));  //2nd Argument is runnable

        int maxInt = Arrays.stream(new int[]{20, 3, 654, 55, 4})
                .max()
                .getAsInt();
        //Any duplicate return true

        boolean anyDuplicate = list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue() > 1);
        System.out.println(anyDuplicate);


        //First Repeating character
        String input = "Sample ample";
        Character resultChar = input.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> input.indexOf(ch) != input.lastIndexOf(ch))  // == For non repeating
                .findFirst().orElse('c');
        System.out.println(resultChar);

        System.out.println(java.time.LocalDateTime.now());

        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<String> stream2 = Stream.of("Ram");
        Stream.concat(stream1,stream2)
                .map(s -> (Object) s)
                .forEach(System.out::println); // Works but can give casting issues
    }
}

//| Scenario                              | Use                               | Reason                                                                   |
//| ------------------------------------- | --------------------------------- | ------------------------------------------------------------------------ |
//| Transform object stream (`Stream<T>`) | `map()`                           | Generic mapping from `T` to `R`.                                         |
//| Transform primitive stream to object  | `mapToObj()`                      | Required when working with `IntStream`, `LongStream`, or `DoubleStream`. |
//| Object → primitive                    | `mapToInt()`, `mapToLong()`, etc. | If you want to convert objects to primitives for numeric processing.     |
