package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@SpringBootApplication(scanBasePackages="com.example.restservice")

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.restservice")
public class MainApplication {


    public static void main(String[] args) {

        
        //SpringApplication.run(RestServiceApplication.class, args);

        SpringApplication app = new SpringApplication(MainApplication.class);
        //app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);


    }


}
