package com.dependencyInjection.di2;

import org.springframework.stereotype.Component;

@Component
public class AndroidSystem implements OperatingSystem {
    @Override
    public void showDetails() {
        System.out.println("SYSTEM : ANDROID");
    }
}
