package com.dependencyInjection.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjection {

    private Dependency dependency;

    @Autowired
    public ConstructorInjection(@Qualifier("someDependency1") Dependency dependency) {
        this.dependency = dependency;
    }

    public void showDependencyName() {
        System.out.println("\n" + this.getClass().getSimpleName() + ": " + dependency.getDependencyName());
    }

}
