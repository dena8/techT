package com.example.techtopic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.FileReader;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean()
    @Scope("prototype")
    public StringBuilder stringBuilder(){
        return new StringBuilder();
    }

}
