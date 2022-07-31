package com.tech.sharedapp.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class AuditProcessor implements IAuditProcessor, ApplicationListener<ContextRefreshedEvent> {

    private final Environment environment;
    @PersistenceContext
    private EntityManager entityManager;
    private static Logger LOG = LogManager.getLogger(AuditProcessor.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //entityManager
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.schema") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.table") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.mapping_table") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.audit_mode") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.audit_retention") + " #####");
        generateAuditTables();
    }

    @Override
    public void generateAuditTables() {
        LOG.info("Perform Audit task");
    }
}
