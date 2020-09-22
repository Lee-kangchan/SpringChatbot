package com.dsu.chat.redis;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisManager {

    @Resource(name = "jedis")
    Jedis jedis;

    public void admin(){ // 관리자 세션 (50분동안 움직이지 않으면 챗봇에 대한 데이터를 받을 수 없음)
        jedis.set("admin", "1");
        jedis.expire("admin",3000);
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



    //response data
    public String getResponse (String data) {
        return jedis.hget("response" , data);
    }
    //response data insert
    public void setResponse(String key, String value){
        jedis.hset("response" , key , value);
    }


    //Button Data 있으면 출력 없으면 null
    public Map<String,String> buttonData(String data){
        Map<String,String> hash = jedis.hgetAll("button");
        if(!hash.get(data).isEmpty()){
            return hash;
        }
        return null;
    }
    // button이 필요한 데이터 추가
    public void setButton(String data, String label, String url){
        Map<String, String> hash =  new HashMap<>();
        jedis.hset(data , "label" , label);
        jedis.hset(data , "action", "webLink");
        jedis.hset(data , "webLinkUrl",url);

    }


}
