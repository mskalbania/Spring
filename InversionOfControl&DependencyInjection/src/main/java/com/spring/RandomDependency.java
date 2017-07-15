package com.spring;

public class RandomDependency implements CoachDependency {

    private final String[] greetings = {"Hi", "Hello", "Good Morning"};

    private String getRandomGreeting() {

        int randomIndex = (int) (Math.random() * 3);
        return greetings[randomIndex];
    }

    @Override
    public String getDependency() {
        return getRandomGreeting();
    }
}
