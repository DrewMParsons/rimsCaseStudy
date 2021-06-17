package com.rims.drew.parsons;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;






@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.rims.drew.parsons.entity"})
public class WebApplication extends SpringBootServletInitializer{
    
	public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}
