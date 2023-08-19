package com.app.testtaskjavaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//ComponentScan(basePackages = "com.app.testtaskjavaback.*")
//@EntityScan("com.app.testtaskjavaback.*")
//@EnableJpaRepositories(basePackages = "com.app.testtaskjavaback.repository")
//@Configuration
public class TestTaskJavaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskJavaBackApplication.class, args);
    }

}
