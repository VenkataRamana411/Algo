package lld.patterns.factory.courses;

import lld.patterns.factory.module.Module;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {

    protected List<Module> modules = new ArrayList<>();

    //It needs constructor as Abstract can have non-abstract fields and methods as well. Refer parkinglot
    public Course(){
        this.createCourse();
    }

    public List<Module> getModules() {
        return modules;
    }

    public abstract void createCourse();
}
