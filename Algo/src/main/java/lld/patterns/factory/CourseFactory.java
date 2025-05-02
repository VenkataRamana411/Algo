package lld.patterns.factory;

import lld.patterns.factory.courses.Course;
import lld.patterns.factory.courses.HLD;
import lld.patterns.factory.courses.LLD;

public class CourseFactory {

    public static Course createCourse(String courseType) {
        switch (courseType) {
            case "HLD":
                return new HLD();
            case "LLD":
                return new LLD();
            default:
                return null;
        }

    }
}
