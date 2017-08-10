package com.dependencyInjection.di2;

public interface MobileDevice {
    void displayOperatingSystem();

    default void displayDeviceName(){
        System.out.println(this.getClass().getSimpleName());
    }
}
