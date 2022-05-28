package com.example.techtopic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean()
    @Scope("prototype")
    public StringBuilder stringBuilder(){
        return new StringBuilder();
    }

}
