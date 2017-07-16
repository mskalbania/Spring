package com.dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig2.xml");

        ConstructorInjection constructor = context.getBean("constructorInjection", ConstructorInjection.class);
        constructor.showDependencyName();

        MethodInjection method = context.getBean("methodInjection", MethodInjection.class);
        method.showDependencyName();

        ReflectionInjection reflection = context.getBean("reflectionInjection", ReflectionInjection.class);
        reflection.showDependencyName();

    }
}
