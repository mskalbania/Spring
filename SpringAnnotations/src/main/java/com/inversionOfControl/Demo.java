package com.inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig1.xml");

        Bean bean1 = context.getBean("beanClass1", BeanClass1.class);

        System.out.println(bean1.getClassName());

        context.close();


    }
}
