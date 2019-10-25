package com.javaxiaodi.springapi.listener;

import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author: Xiaodi Tao
 * @className: AppRunner
 * @packageName: listener
 * @description: This is the listener
 * @data: 2019-10-25
 **/
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(AppRunner.class);
        Logger.info("ApplicationRunner...run....");
    }
}
