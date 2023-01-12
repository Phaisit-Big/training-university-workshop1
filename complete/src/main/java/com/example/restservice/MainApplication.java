package com.example.restservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


//@SpringBootApplication(scanBasePackages="com.example.restservice")

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.restservice")
public class MainApplication {


    public static void main(String[] args) {

        
        //SpringApplication.run(RestServiceApplication.class, args);

        SpringApplication app = new SpringApplication(MainApplication.class);
        //app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        final ConfigurableApplicationContext context = app.run(args);


        // System.out.println("--------------- BEAN DEFINITION ----------------");
        // for (String beanName: context.getBeanDefinitionNames()) {
        //     System.out.println(beanName);
        // }	
		
		// System.out.println("----------------- ENVIRONMENT ------------------");
		// Environment env = context.getEnvironment();
		// System.out.println("Started on port: " + env.getProperty("server.port"));
        	
    }


}
