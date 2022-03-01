package com.kane.jedis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author : zsk_kane
 * @date : 2022-02-23 10:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTest {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 简单测试 redisTemplate  和  stringRedisTemplate 的读写缓存
     */
    @Test
    public void redisTemplateTest() {

        redisTemplate.opsForValue().set("redis template key", "redis template value");

        stringRedisTemplate.opsForValue().set("string redis template key", "string redis template value");

        System.out.println(redisTemplate.opsForValue().get("redis template key"));
        System.out.println(stringRedisTemplate.opsForValue().get("string redis template key"));

    }

    /**
     * 简单测试 RedisUtils 的读写缓存
     */
    @Test
    public void redisUtilsTest() {

        redisUtils.set("redis utils key", "redis utils value");

        System.out.println(redisUtils.get("redis utils key"));

    }







}
