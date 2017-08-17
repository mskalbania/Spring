package com.dependencyInjection.di1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig2.xml");

        ConstructorInjection constructor = context.getBean("constructorInjection", ConstructorInjection.class);
        constructor.showDependencyName();

        MethodInjection method = context.getBean("methodInjection", MethodInjection.class);
        method.showDependencyName();

        ReflectionInjection reflection = context.getBean("reflectionInjection", ReflectionInjection.class);
        reflection.showDependencyName();

        context.close();
    }
}