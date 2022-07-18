package com.tech.sharedapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class PreProcessorService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("##### Ruuning pre processor ##"+ environment.getProperty("db.schema")+ " #####");
    }
}
