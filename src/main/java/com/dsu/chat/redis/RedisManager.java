package com.dsu.chat.redis;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RedisManager {

    @Resource(name = "jedis")
    Jedis jedis;

    public void login(){
        jedis.set("admin","1");
        jedis.expire("admin", 3000);
        jedis.close();
    }
    public String admin(){ // 관리자 세션 (30분동안 움직이지 않으면 챗봇에 대한 데이터를 받을 수 없음)


        Set<String> id = jedis.keys("*");
        if(!id.contains("admin")){
            return "0";
        }

        jedis.expire("admin",1800);
        jedis.close();
        return "1";
    }
    public void reset(){
        jedis.set("admin","1");
        jedis.expire("admin", 0);
        jedis.close();
    }

    // 질문을 받는 공간
    public void setData(String key , String name){
        jedis.sadd(key,name);
    }
    // 질문의 목록
    public Set<String> getData(String key){
        return jedis.smembers(key);
    }
    //질문 처리 했으면 삭제
    public void delData(String name){
        jedis.srem(name);
    }

    public List<Map<String, Object>> chat(){
        Set<String> t = jedis.hkeys("response");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map ;
        for(String i : t){
            map = new HashMap<>();
            map.put("key",i);
            map.put("value", jedis.hget("response",i));
            list.add(map);
        }
        jedis.close();
        return list;
    }
    public void putData(String key,String value){
        jedis.hset("response", key, value);
    }

    //response data
    public String getResponse (String data) {
        String t = jedis.hget("response" , data);
        jedis.close();
        return t;
    }
    //response data insert

    public void setResponse(String key, String value){
        jedis.hset("response" , key , value);
        jedis.close();
    }





}
