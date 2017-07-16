package com.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ReflectionInjection {

    @Autowired
    @Qualifier("someDependency3")
    private Dependency dependency;

    public void showDependencyName() {
        System.out.println("\n"+ this.getClass().getSimpleName()+ ": " + dependency.getDependencyName());
    }

}
