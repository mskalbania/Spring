package com.dependencyInjection.di1;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency1 implements Dependency {

    @Override
    public String getDependencyName() {
        return "SOME DEPENDENCY 1";
    }
}
