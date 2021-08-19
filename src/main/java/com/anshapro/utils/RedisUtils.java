package com.anshapro.utils;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisUtils {

    public static Jedis getRdis(){
        Jedis jedis = new Jedis("120.78.190.74",6379);
        jedis.auth("yyf)()#!^");
        String ping = jedis.ping();
        System.out.println("连接redis,状态："+ping);
        return jedis;
    }



    @Test
    public void test(){
        Jedis rdis = getRdis();
    }
}
