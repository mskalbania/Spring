package com.dependencyInjection.di1;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency2 implements Dependency {
    @Override
    public String getDependencyName() {
        return "SOME DEPENDENCY 2";
    }
}
