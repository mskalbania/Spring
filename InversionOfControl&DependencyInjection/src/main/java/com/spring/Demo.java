package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext1.xml");

        //CONSTRUCTOR INJECTION
        Coach coach1 = context.getBean("baseball", Coach.class);
        System.out.println(coach1.getDailyWorkout());

        //SETTER INJECTION
        Coach coach2 = context.getBean("football", Coach.class);
        System.out.println(coach2.getDailyWorkout());

        context.close();
    }
}
