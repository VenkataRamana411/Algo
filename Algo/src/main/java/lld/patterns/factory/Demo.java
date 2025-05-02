package lld.patterns.factory;

import lld.patterns.factory.courses.Course;

public class Demo {
    public static void main(String[] args) {
        Course hldCourse = CourseFactory.createCourse("HLD");
        Course lldCourse = CourseFactory.createCourse("LLD");
        System.out.println(hldCourse.getModules());
        System.out.println(lldCourse.getModules());
    }
}
