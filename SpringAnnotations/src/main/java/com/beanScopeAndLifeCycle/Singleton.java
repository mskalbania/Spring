package com.beanScopeAndLifeCycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class Singleton {

    Singleton() {
        System.err.println("\nSINGLETON OBJECT CREATED");
    }

    @PostConstruct
    public void initialize(){
        System.err.println("INITIALIZATION....");
    }

    @PreDestroy
    public void cleanUp(){
        System.err.println("OBJECT DESTROYED");
    }

}
