package com.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency3 implements Dependency{
    @Override
    public String getDependencyName() {
        return "SOME DEPENDENCY 3";
    }
}
