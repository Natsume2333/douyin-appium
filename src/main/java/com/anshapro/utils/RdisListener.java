package com.anshapro.utils;

import com.anshapro.DouyinAppium;
import io.appium.java_client.android.AndroidDriver;
import redis.clients.jedis.JedisPubSub;

import java.net.MalformedURLException;

public class RdisListener extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage"+message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage");
    }

    @Override
    public void onPong(String pattern) {
        System.out.println("onPong");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onMessage");
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("初始化..");
        DouyinAppium douyinAppium = new DouyinAppium();
        try {
            AndroidDriver driver = douyinAppium.init();
            // 第一次进入
            douyinAppium.first(driver);

            douyinAppium.seach(driver,"财商之道大庆麦咚教育咨询有限公司");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe");
    }
}
