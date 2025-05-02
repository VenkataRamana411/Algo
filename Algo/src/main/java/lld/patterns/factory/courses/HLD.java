package lld.patterns.factory.courses;

import lld.patterns.factory.module.DemoModule;
import lld.patterns.factory.module.IntroModule;
import lld.patterns.factory.module.SummaryModule;

public class HLD extends Course{
    @Override
    public void createCourse() {
        modules.add(new IntroModule());
        modules.add(new DemoModule());
        modules.add(new SummaryModule());
    }
}
