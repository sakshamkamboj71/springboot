package com.demoApp.testing;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    public void compile(){
        System.out.println("DESKTOP IS COMPILING");
    }

}
