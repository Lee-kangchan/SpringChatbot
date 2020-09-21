package com.dsu.chat.redis;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Service
public class RedisManager {

    @Resource(name = "jedis")
    Jedis jedis;

    public void setData(String name , String listData){
        jedis.select(10);
        jedis.set(listData,name);
    }
    public String getData(String chat){
        jedis.select(10);
        if (jedis.get(chat)!=null){
            System.out.println(jedis.get(chat));
            return jedis.get(chat);
        }
        return "x";
    }
}
