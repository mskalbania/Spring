package com.spring;

public class GreetingDependency implements CoachDependency {
    @Override
    public String getDependency() {
        return "Hello";
    }
}
