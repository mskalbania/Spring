package com.spring;

public class FootballCoach implements Coach {

    private String teamName;
    private CoachDependency coachDependency;

    //VALUE INJECTION
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    //OBJECT INJECTION
    public void setCoachDependency(CoachDependency coachDependency) {
        System.out.println("Setter invoked by spring");
        this.coachDependency = coachDependency;
    }

    @Override
    public String getDailyWorkout() {
        return "Standard football workout || " +
                this.teamName + " || " +
                coachDependency.getDependency();
    }
}
