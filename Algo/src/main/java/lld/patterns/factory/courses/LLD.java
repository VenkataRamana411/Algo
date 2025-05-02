package lld.patterns.factory.courses;

import lld.patterns.factory.module.ExcerciseModule;
import lld.patterns.factory.module.IntroModule;
import lld.patterns.factory.module.SummaryModule;

public class LLD extends Course{
    @Override
    public void createCourse() {
        modules.add(new IntroModule());
        modules.add(new ExcerciseModule());
        modules.add(new SummaryModule());
    }
}
