package com.raduq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Runner da aplicação quando embbed.
 * @author raduq em 17/01/17
 */
@ComponentScan
@EnableAutoConfiguration(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class MarsApplication extends SpringBootServletInitializer {

    private static final String PATH_MAPPING = "/**";
    private static final String OPTIONS = "OPTIONS";
    private static final String PUT = "PUT";
    private static final String DELETE = "DELETE";
    private static final String POST = "POST";
    private static final String GET = "GET";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MarsApplication.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(PATH_MAPPING).allowedMethods(GET, POST, DELETE, PUT, OPTIONS);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MarsApplication.class, args);
    }

}
