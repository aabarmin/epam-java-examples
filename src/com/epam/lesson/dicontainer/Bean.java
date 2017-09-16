package com.epam.lesson.dicontainer;

public class Bean {
    @Inject @Basic
    private DependencyBean dependency;

    public DependencyBean getDependency() {
        return dependency;
    }

    public void setDependency(DependencyBean dependency) {
        this.dependency = dependency;
    }
}
