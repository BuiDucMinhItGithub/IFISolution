package com;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableBatchProcessing
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoDbApplication.class, args);
    }


}
