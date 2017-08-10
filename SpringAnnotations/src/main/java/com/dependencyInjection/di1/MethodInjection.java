package com.dependencyInjection.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MethodInjection {

    private Dependency dependency;

    @Autowired
    @Qualifier("someDependency2")
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Autowired
    @Qualifier("someDependency2")
    public void anyMethodNameCanBeAutowired(Dependency dependency) {
        this.dependency = dependency;
    }

    @PostConstruct
    public void startup() {
        System.out.println("***STARTUP INVOKED***");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("***CLEAN UP INVOKED***");
    }

    public void showDependencyName() {
        System.out.println("\n" + this.getClass().getSimpleName() + ": " + dependency.getDependencyName());
    }

}
