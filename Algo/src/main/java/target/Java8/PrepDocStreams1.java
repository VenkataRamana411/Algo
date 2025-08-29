package target.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrepDocStreams1 {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 4, 5, 6, 2, 7, 8, 9, 10);
        integerList.stream().filter(n -> n % 2 == 0).forEach(System.out::print);

        long count = integerList.stream().filter(n -> n > 5).count();

        List<Integer> distinctList = integerList.stream()
                .distinct() //Stream<Integer>
                .collect(Collectors.toList());

        Integer sumOfIntegers = integerList.stream().reduce(6, Integer::sum);  //  (a, b) -> a + b
        System.out.println("Sum" + sumOfIntegers);

        int max = integerList.stream().max(Comparator.comparingInt(a -> a)).get();
        int maxAsInt = integerList.stream().mapToInt(a -> a).max().getAsInt();
        int sum = integerList.stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println();
        integerList.stream().sorted().forEach(System.out::print);

        boolean anyMatch = integerList.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().anyMatch(entry -> entry.getValue() > 1);

        List<Integer> cubeList = integerList.stream().map(n -> n * n * n).filter(value -> value < 250).collect(Collectors.toList());
        System.out.println(cubeList);

        List<String> stringList = List.of("Hi", "there", "ramana", "here");
        List<String> upperCaseStrings = stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());   //map(String::toUpperCase)
        System.out.println(upperCaseStrings);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ram",5000,"IT"));
        employeeList.add(new Employee("Venkat",15000,"IT"));
        employeeList.add(new Employee("Shyam",7000,"Audit"));
        employeeList.add(new Employee("Pavan",3000,"Audit"));

        Double average = employeeList.stream().mapToInt(Employee::getSalary).average().getAsDouble();

        List<String> resultListEmployee = employeeList.stream().filter(employee -> employee.getSalary() > average).map(Employee::getName).collect(Collectors.toList());

        Map<String, String> collect = employeeList.stream().collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
        Map<String, Optional<Employee>> collect1 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        Map<String, Integer> maxSalaryByDept = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                emp -> emp.get().getSalary()
                        )
                ));

        System.out.println(employeeList);
    }
}
