package com.javaxiaodi.springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author: Xiaodi Tao
 * @className: SpringapiApplication
 * @packageName: com.javaxiaodi.springapi
 * @description: This is the class that has the main method, the
 * application should be started by running the main method here
 * @data: 2019-10-25
 **/
@SpringBootApplication
@EnableCaching
public class SpringapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringapiApplication.class, args);
	}

}
