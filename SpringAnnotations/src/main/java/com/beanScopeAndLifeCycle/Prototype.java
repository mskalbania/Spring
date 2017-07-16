package com.beanScopeAndLifeCycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Prototype {

    Prototype(){
        System.out.println("prt constructor invoked");
    }

}
