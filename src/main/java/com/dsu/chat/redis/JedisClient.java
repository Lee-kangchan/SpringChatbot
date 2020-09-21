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
        Pool<Jedis> jedisPool;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 10000000, "1234");

        return jedisPool.getResource();
    }
}
