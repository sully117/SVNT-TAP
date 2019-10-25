package com.javaxiaodi.springapi.listener;

import com.javaxiaodi.springapi.filter.MyFilter;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: Xiaodi Tao
 * @className: AppContextInitializer
 * @packageName: listener
 * @description: This is the listener
 * @data: 2019-10-25
 **/
public class AppContextInitializer implements org.springframework.context.ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(AppContextInitializer.class);
        Logger.info("AppContextInitializer...initialize..."+applicationContext);
    }
}
