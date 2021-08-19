package com.anshapro.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;

import java.util.List;

public class Find {

    private static int time = 20;

    public static WebElement find(AppiumDriver driver, By by){
        WebElement webElement = null;
        try {
            webElement = driver.findElement(by);
        } catch (Exception e){
//sth
        }
        return webElement;
    }
    public static List<WebElement> finds(AppiumDriver driver, By by){
        List<WebElement> elements = null;
        try{
            elements = driver.findElements(by);
        }catch (Exception e){

        }
        return elements;
    }

    public static WebElement findElement(AppiumDriver driver, By by) throws InterruptedException {
        WebElement webElement = null;
        for (int i = 0; i < time; i++) {
            if (find(driver, by) != null){
                System.out.println("尝试第"+i+"次查找");
                webElement = find(driver, by);
                break;
            }
            System.out.println("第"+i+"次没查到");
            Thread.sleep(500);
        }
        return webElement;
    }
    public static List<WebElement> findElements(AppiumDriver driver, By by) throws InterruptedException {
        List<WebElement> elements = null;

        for (int i = 0; i < time; i++) {
            if (finds(driver, by).size() > 0){
                elements = finds(driver, by);
                break;
            }
            Thread.sleep(500);
        }
        return elements;
    }




}
