package com.springXML;

public class GreetingDependency implements com.springXML.CoachDependency {
    @Override
    public String getDependency() {
        return "Hello";
    }
}
