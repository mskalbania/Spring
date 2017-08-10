package com.springXML;

public class BaseballCoach implements com.springXML.Coach {

    private com.springXML.CoachDependency dependency;

    public BaseballCoach(com.springXML.CoachDependency dependency) {
        System.out.println("Constructor invoked by springXML");
        this.dependency = dependency;
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball simple workout || " + dependency.getDependency();
    }
}
