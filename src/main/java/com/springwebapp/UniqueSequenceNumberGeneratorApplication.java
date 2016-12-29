package com.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springwebapp.domain")
@EntityScan(basePackages = "com.springwebapp.domain")
public class UniqueSequenceNumberGeneratorApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UniqueSequenceNumberGeneratorApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UniqueSequenceNumberGeneratorApplication.class, args);
    }
}
