package com.javaxiaodi.springapi.listener;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * @author: Xiaodi Tao
 * @className: CommandLinesRunner
 * @packageName: listener
 * @description: This is the listener
 * @data: 2019-10-25
 **/
@Component
public class CommandLinesRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(AppRunner.class);
        Logger.info("CommandLineRunner...run..."+ Arrays.asList(args));
    }
}
