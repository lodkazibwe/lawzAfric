package com.lawyersofafrica.lawyersofafrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class LawyersofafricaApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
        SpringApplication.run(LawyersofafricaApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){return new RestTemplate();}

}
