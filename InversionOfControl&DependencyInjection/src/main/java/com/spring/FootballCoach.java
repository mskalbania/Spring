package com.spring;

public class FootballCoach implements Coach {

    private CoachDependency coachDependency;

    public void setCoachDependency(CoachDependency coachDependency) {
        System.out.println("Setter invoked by spring");
        this.coachDependency = coachDependency;
    }

    @Override
    public String getDailyWorkout() {
        return "Standard football workout || " + coachDependency.getDependency();
    }
}
