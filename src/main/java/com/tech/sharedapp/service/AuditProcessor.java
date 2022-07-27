package com.tech.sharedapp.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


// TODO: Fix ME
@Service
@RequiredArgsConstructor
public class AuditProcessor implements IAuditProcessor, ApplicationListener<ContextRefreshedEvent> {

    private final Environment environment;
    private static Logger LOG = LogManager.getLogger(AuditProcessor.class);

    private JdbcTemplate jdbcTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.schema") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.table") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.mapping_table") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.audit_mode") + " #####");
        LOG.info("##### Ruuning pre processor ##" + environment.getProperty("db.audit.audit_retention") + " #####");
    }

    @Bean("primaryDataSource")
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:/data/demo");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @PostConstruct
    @DependsOn("primaryDataSource")
    public void postInitialization() {
        jdbcTemplate = new JdbcTemplate();

    }

    @Override
    public void generateAuditTables() {
        jdbcTemplate.execute("SELECT 1");
    }
}
