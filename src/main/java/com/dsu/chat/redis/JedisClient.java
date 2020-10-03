package com.dsu.chat.redis;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.util.Pool;

@Configuration
public class JedisClient {
    @Bean
    public Jedis jedis() {

        Jedis jedis = new Jedis("helloredis.36dxq7.ng.0001.apn2.cache.amazonaws.com", 6379);

        return jedis;
    }
}
