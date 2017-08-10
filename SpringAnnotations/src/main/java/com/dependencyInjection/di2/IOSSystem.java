package com.dependencyInjection.di2;

import org.springframework.stereotype.Component;

@Component
public class IOSSystem implements OperatingSystem {
    @Override
    public void showDetails() {
        System.out.println("SYSTEM : IOS");
    }
}

