package com.spring;

public class BaseballCoach implements Coach {

    private CoachDependency dependency;

    public BaseballCoach(CoachDependency dependency) {
        System.out.println("Constructor invoked by spring");
        this.dependency = dependency;
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball simple workout || " + dependency.getDependency();
    }
}
