package com.dependencyInjection.di2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Demo {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MobileConfiguration.class);

        Samsung samsung = context.getBean("samsung", Samsung.class);
        samsung.display();

        IPhone iPhone = context.getBean("IPhone", IPhone.class);
        iPhone.display();

        Tablet tablet = context.getBean("tablet", Tablet.class);
        tablet.display();

        context.close();
    }
}
