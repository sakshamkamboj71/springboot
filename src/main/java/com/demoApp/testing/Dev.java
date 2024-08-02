package com.demoApp.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev{

    @Autowired
    @Qualifier("desktop")
    private Computer comp;

    public Dev(Computer comp){
        this.comp = comp;
    }

    public void doTask() {
        comp.compile();
    }
}