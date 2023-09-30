package ks.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("aram","m");
        personList.add(person1);
        Person person2 = new Person("zram","m");
        personList.add(person2);
        Person person3 = new Person("cram","m");
        personList.add(person3);
        Person person4 = new Person("cram","m");
        personList.add(person4);
        System.out.println(personList);
        helper(personList);
    }
    private static void helper(List<Person> personList){
        List<String> names = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        SortedSet<Person> personSortedSet = new TreeSet<>(Comparator.comparing(Person::getName));
        personList.parallelStream().forEach(person -> {
           /* if (!names.contains(person.getName())){
                person.setGender(null);
                names.add(person.getName());
                people.add(person);
            }*/
            person.setGender(null);
            personSortedSet.add(person);
        });
        //people.sort(Comparator.comparing(Person::getName));
        //List<Person> collected = people.parallelStream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        //List<Person> collect = personList.stream().distinct().collect(Collectors.toList());
        personList.clear();
        personList.addAll(personSortedSet);
        System.out.println(personList);
    }
}
