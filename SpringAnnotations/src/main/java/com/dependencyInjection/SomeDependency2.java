package com.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency2 implements Dependency {
    @Override
    public String getDependencyName() {
        return "SOME DEPENDENCY 2";
    }
}
