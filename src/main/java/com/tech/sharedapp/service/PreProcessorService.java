package com.tech.sharedapp.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreProcessorService implements ApplicationListener<ContextRefreshedEvent> {

    private final Environment environment;
    private static Logger logger = LogManager.getLogger(PreProcessorService.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("##### Ruuning pre processor ##" + environment.getProperty("db.schema") + " #####");
        logger.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.table") + " #####");
        logger.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.mapping_table") + " #####");
        logger.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.audit_mode") + " #####");
        logger.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.audit_retention") + " #####");

    }
}
