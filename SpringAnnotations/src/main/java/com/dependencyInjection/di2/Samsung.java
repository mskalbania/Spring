package com.dependencyInjection.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung extends Phone {

    private OperatingSystem operatingSystem;

    @Autowired
    public Samsung(@Qualifier("androidSystem") OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void display() {
        operatingSystem.showDetails();
    }
}
