package com.beanScopeAndLifeCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig3.xml");

        Singleton sig1 = context.getBean("singleton", Singleton.class);
        Singleton sig2 = context.getBean("singleton", Singleton.class);

        System.out.println("ARE THEY EQUAL? " + sig1.equals(sig2));
        System.out.println("--REFS--");
        System.out.println(sig1 + "  |  " + sig2 + "\n\n");


        Prototype prt1 = context.getBean("prototype", Prototype.class);
        Prototype prt2 = context.getBean("prototype", Prototype.class);

        System.out.println("ARE THEY EQUAL? " + prt1.equals(prt2));
        System.out.println("--REFS--");
        System.out.println(prt1 + "  |  " + prt2);

        context.close();
    }
}
