package com.dependencyInjection.di2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Demo2 {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MobileConfiguration.class);

        Samsung samsung = context.getBean("smsg", Samsung.class);
        samsung.displayDeviceName();
        samsung.displayOperatingSystem();

        IPhone iPhone = context.getBean("IPhone", IPhone.class);
        iPhone.displayDeviceName();
        iPhone.displayOperatingSystem();

        Tablet tablet = context.getBean("tablet", Tablet.class);
        tablet.displayDeviceName();
        tablet.displayOperatingSystem();

        context.close();
    }
}
