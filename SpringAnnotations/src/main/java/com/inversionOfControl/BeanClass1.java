package com.inversionOfControl;

import org.springframework.stereotype.Component;

@Component
public class BeanClass1 implements Bean {

    @Override
    public String getClassName(){
        return "BEAN 1";
    }
}
