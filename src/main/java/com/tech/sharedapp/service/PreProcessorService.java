package com.tech.sharedapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreProcessorService {

    private final Environment environment;

    public void initialiseAudit() {
        System.out.println("##### Ruuning pre processor ##"+ environment.getProperty("db.schema")+ " #####");
        System.out.println("##### Ruuning pre processor ##"+ environment.getProperty("db.audit.table")+ " #####");
        System.out.println("##### Ruuning pre processor ##"+ environment.getProperty("db.audit.mapping_table")+ " #####");
        System.out.println("##### Ruuning pre processor ##"+ environment.getProperty("db.audit.audit_mode")+ " #####");
        System.out.println("##### Ruuning pre processor ##"+ environment.getProperty("db.audit.audit_retention")+ " #####");
    }

}
