package com.dependencyInjection.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IPhone extends Phone{

    private OperatingSystem operatingSystem;

    @Autowired
    public IPhone(@Qualifier("IOSSystem") OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void displayOperatingSystem() {
        operatingSystem.showDetails();
    }
}
