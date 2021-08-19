package com.anshapro.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Swipe {
    public static void SwipeUp(AppiumDriver driver) {
        int width = driver.manage().window().getSize().width; //获取屏幕的宽
        int height = driver.manage().window().getSize().height; //获取屏幕的长
        System.out.println("width:"+width+",height:"+height);
        PointOption pointOption = new PointOption();
        Duration duration=Duration.ofMillis(500);//滑动500ms
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(pointOption.point(width/3,height/5))
                .waitAction(WaitOptions.waitOptions(duration))
                .moveTo(pointOption.point(width/3,height-height/5))
                .release().perform();

    }
    public static void SwipeDown(AppiumDriver driver) {
        int width = driver.manage().window().getSize().width; //获取屏幕的宽
        int height = driver.manage().window().getSize().height; //获取屏幕的长
        System.out.println("width:"+width+",height:"+height);
        PointOption pointOption = new PointOption();
        Duration duration=Duration.ofMillis(500);//滑动500ms
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(pointOption.point(width/3,height-height/5))
                .waitAction(WaitOptions.waitOptions(duration))
                .moveTo(pointOption.point(width/3,height/5))
                .release().perform();

    }
}
