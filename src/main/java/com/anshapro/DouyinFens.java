package com.anshapro;
import com.anshapro.utils.Find;
import com.anshapro.utils.RdisListener;
import com.anshapro.utils.RedisUtils;
import com.anshapro.utils.Swipe;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import redis.clients.jedis.Jedis;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class DouyinFens {
    public static AndroidDriver driver;


    public static void main(String[] args) {
        RdisListener rdisListener = new RdisListener();
        Jedis rdis = RedisUtils.getRdis();
        rdis.subscribe(rdisListener,"douyin:user");
    }


    

}
