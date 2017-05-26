package com.heidou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author heidou.f
 *         2017/3/25.
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages="com.heidou.repository")

public class BookApplication {
    public static void main(String[] args){
        SpringApplication.run(BookApplication.class);
    }
}
