package com.heidou.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author: heidou
 * @description:
 * @data2017/5/15.
 */
@Component
public class RedisComponent {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    private ValueOperations<Object,Object> operations;

    @PostConstruct
    public void init(){
        operations = redisTemplate.opsForValue();
    }

    public void setString(String key, String value) {
        operations.set(key, value);
    }

    public void setString(String key, String value, Long expire) {
        operations.set(key, value, expire, TimeUnit.SECONDS);
    }

    public String getString(String key) {
        if(StringUtils.isBlank(key)){
            return null;
        }
        Object obj = operations.get(key);
        if(obj==null){
            return null;
        }
        return String.valueOf(obj);
    }

    public void set(Object key, Object value) {
        operations.set(key, value);
    }

    public void set(Object key, Object value, Long expire) {
        operations.set(key, value, expire, TimeUnit.SECONDS);
    }

    public Object get(Object key) {
        return operations.get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }



}
