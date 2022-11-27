package com.tech.sharedapp.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContext  implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setAppContext(applicationContext);
    }

    private static synchronized  void setAppContext(ApplicationContext applicationContext) {
        AppContext.applicationContext =applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
