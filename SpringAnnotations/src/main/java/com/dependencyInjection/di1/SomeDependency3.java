package com.dependencyInjection.di1;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency3 implements Dependency{
    @Override
    public String getDependencyName() {
        return "SOME DEPENDENCY 3";
    }
}
