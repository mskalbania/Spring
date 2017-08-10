package com.springXML;

public class FootballCoach implements com.springXML.Coach {

    private String teamName;
    private com.springXML.CoachDependency coachDependency;

    //VALUE INJECTION
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    //OBJECT INJECTION
    public void setCoachDependency(com.springXML.CoachDependency coachDependency) {
        System.out.println("Setter invoked by springXML");
        this.coachDependency = coachDependency;
    }

    @Override
    public String getDailyWorkout() {
        return "Standard football workout || " +
                this.teamName + " || " +
                coachDependency.getDependency();
    }
}
