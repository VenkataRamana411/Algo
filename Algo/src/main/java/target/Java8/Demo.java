package target.Java8;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        studentWithMaxMarksInSubject();
    }

//    Lambda & Stream-Based Questions:
//    Find the Average Marks in Maths
//
//    Write a lambda expression to calculate the average marks of all students in Maths.
//
//    List Students Who Scored More Than 95 in Any Subject
//
//    Use streams to filter students who have scored above 95 in any subject.
//
//    Find the Student with the Most Number of Subjects
//
//    Determine the student who is studying the highest number of subjects.
//
//    Get a Map of Student Names and Their Average Marks
//
//    Generate a Map<String, Double> where the key is the student’s name and the value is their average marks.
//
//    Find the Subject with the Highest Overall Marks Across All Students
//
//    Identify the subject that has the highest total marks across all students.
//
//    Sort Students Based on Their Total Marks
//
//    Sort and print students based on their total marks in descending order.
//
//    Find the Top Scoring Subject for Each Student
//
//    Create a Map<String, String> where the key is the student’s name and the value is their highest scoring subject.
//
//    Group Students by Subjects Taken
//
//    Create a Map<String, List<String>> where the key is a subject name and the value is a list of students taking that subject.
//
//            Check if Any Student Has a Perfect Score in Any Subject
//
//    Use a lambda expression to check if any student has scored 100 in any subject.
//
//    Find the Second Highest Marks in Maths
//
//    Modify the existing logic to find the second highest scorer in Maths instead of the highest.

    private static void studentWithMaxMarksInSubject() {
        Subject subject1 = new Subject("Maths", 98);
        Subject subject2 = new Subject("Maths", 92);
        Subject subject3 = new Subject("Maths", 100);
        Subject subject4 = new Subject("Science", 95);
        Subject subject5 = new Subject("Social", 94);
        Subject subject6 = new Subject("Telugu", 99);

        List<Subject> subjectList1 = List.of(subject1, subject4);
        List<Subject> subjectList2 = List.of(subject3, subject5);
        List<Subject> subjectList3 = List.of(subject2, subject5, subject6);
        Student student1 = new Student("Ram", subjectList1);
        Student student2 = new Student("Ramana", subjectList2);
        Student student3 = new Student("Venkat", subjectList3);
        List<Student> studentList = List.of(student1, student2, student3);
//        Optional<Student> topMathStudent = studentList.stream()
//                .flatMap(student -> student.getSubjects().stream()
//                        .filter(subject -> subject.getName().equals("Maths"))
//                        .map(subject -> new AbstractMap.SimpleEntry<>(student, subject.getMarks())))
//                .max(Comparator.comparingInt(Map.Entry::getValue))
//                .map(Map.Entry::getKey);

        subjectList1.stream().max(Comparator.comparing(Subject::getMarks)).map(Subject::getSubjectName).get();
        Student result = studentList.stream()
                .flatMap(student -> student.getSubjects().stream()
                        .filter(subject -> subject.getSubjectName().equals("Maths"))
                        .map(subject -> Map.entry(student, subject.getMarks()))
                )
                .max(Comparator.comparingInt(entry -> entry.getValue()))
                .map(studentSubjectSimpleEntry -> studentSubjectSimpleEntry.getKey())
                .orElse(null);
        System.out.println(result);

        /**
         * FindAverageMarksInMaths*/

        double avergaeMathsScore = studentList.stream()
                .flatMap(student -> student.getSubjects().stream())
                .filter(subject -> subject.getSubjectName().equals("Maths"))
                .mapToInt(Subject::getMarks)
                .average()
                .orElse(0);
        //System.out.println(avergaeMathsScore);

        //Use streams to filter students who have scored above 95 in any subject.

        List<Student> students = studentList.stream()
                .flatMap(student -> student.getSubjects().stream()
                        .filter(subject -> subject.getMarks() > 95)
                        .map(subject -> student))
                .collect(Collectors.toList());
        //System.out.println(students);

        //Determine the student who is studying the highest number of subjects.

        Optional<Student> first = studentList.stream()
                .max(Comparator.comparing(student -> student.getSubjects().size()));
        //System.out.println(first.orElseGet(Student::new));


        //Get a Map of Student Names and Their Average Marks
        Map<String, Double> avergaeMap = studentList.stream()
                .collect(Collectors.toMap(Student::getName, student -> student.getSubjects().stream()
                        .mapToInt(Subject::getMarks)
                        .average()
                        .orElse(0)
                ));
        //System.out.println(avergaeMap);

        //Find the Subject with the Highest Overall Marks Across All Students
        String nothing = studentList.stream()
                .flatMap(student -> student.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getSubjectName, Collectors.summingInt(Subject::getMarks)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No subjects found");

        //Sort Students Based on Their Total Marks

        List<Student> studentList1 = studentList.stream()
                .sorted(Comparator.comparingInt(student -> student.getSubjects().stream().mapToInt(Subject::getMarks).sum()))
                .collect(Collectors.toList());
        System.out.println(studentList1);

        Map<String, String> collect = studentList.stream()
                .collect(
                        Collectors.toMap(
                                Student::getName,
                                student -> student.getSubjects().stream()
                                        .max(Comparator.comparingInt(Subject::getMarks))
                                        .map(Subject::getSubjectName)
                                        .orElse("Default")
                        ));
        System.out.println(collect);

        //Group Students by Subjects Taken


    }
}
