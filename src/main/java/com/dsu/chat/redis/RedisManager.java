package com.dsu.chat.redis;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RedisManager {

    @Resource(name = "jedis")
    Jedis jedis;

    public void setData(String name){
        jedis.auth("1234");
        jedis.sadd("data",name);
    }
    public Set<String> getData(){
        jedis.auth("1234");
        return jedis.smembers("data");
    }
}
