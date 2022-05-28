package com.example.techtopic.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentMap;

import static com.example.techtopic.constants.Constants.DATA_STORAGE_MAP;

@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redisClient(@Value("${spring.redis.host}") String host, @Value("${spring.redis.port}") String port) {
        Config config = new Config();
        config.useSingleServer().setAddress(String.format("redis://%s:%s", host, port));
        return Redisson.create(config);
    }
    @Bean
    public ConcurrentMap<String,String> dataStorage(RedissonClient redissonClient){
        return redissonClient.getMap(DATA_STORAGE_MAP);
    }
}
