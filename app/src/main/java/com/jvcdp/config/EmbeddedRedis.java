package com.jvcdp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@ApplicationScope
@Eager
@Component
public class EmbeddedRedis {

    @Value("${spring.redis.port}")
    private int redisPort;

    private static RedisServer redisServer;

    @PostConstruct
    public void startRedis() throws IOException {
        redisServer = new RedisServer(redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }
}
