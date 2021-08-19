package com.anshapro;
import com.anshapro.element.Find;
import com.anshapro.element.Swipe;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class DouyinFens {
    public static AndroidDriver driver;




    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "127.0.0.1:62001"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "Andriod5.1.1");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.ss.android.ugc.aweme");
        cap.setCapability("appActivity", "com.ss.android.ugc.aweme.main.MainActivity");

        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity","com.ss.android.ugc.aweme.main.MainActivity");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);
        cap.setCapability("noReset",true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        if (Find.findElement(driver,new By.ById("com.ss.android.ugc.aweme:id/hd4")) != null){
            System.out.println("点击我同意");
            Find.findElement(driver,new By.ById("com.ss.android.ugc.aweme:id/bk+")).click();
        }
//        if (Find.findElement(driver,new By.ByXPath("//androidx.viewpager.widget.ViewPager[@content-desc=\"视频\"]/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout[9]/android.widget.FrameLayout")) != null){
//
//        }
        // com.ss.android.ugc.aweme:id/i45
        for (int i = 0; i < 15; i++) {
            System.out.println("等待"+(15-i));
            Thread.sleep(1000);
        }

        System.out.println("滑动");

        Swipe.SwipeUp(driver);

        Swipe.SwipeDown(driver);


        Find.findElement(driver,new By.ById("com.ss.android.ugc.aweme:id/j38")).click();

        WebElement seach = Find.findElement(driver, new By.ById("com.ss.android.ugc.aweme:id/et_search_kw"));

        seach.sendKeys("周文强");

        // 搜索
        System.out.println("点击搜索");
        Find.findElement(driver,new By.ById("com.ss.android.ugc.aweme:id/k4g")).click();

        Thread.sleep(10000);
        // 用户
        List<WebElement> element = Find.findElements(driver, new By.ByClassName("androidx.appcompat.app.a$b"));
//        for(WebElement webElement : element){
////            String text = webElement.getText();
//            WebElement element1 = webElement.findElement(new By.ByClassName("android.widget.TextView"));
//            String text = element1.getText();
//            System.out.println("列表text"+text);
//        }
        System.out.println("点击用户");
        element.get(2).click();

        seachUserClick(driver);


        //com.ss.android.ugc.aweme:id/e+f  搜索用户列表



//        WebElement element = Find.findElement(driver, new By.ById("ea838a82-1a56-4246-94b4-6a9abc61f09a"));
//        element.click();

//        List<WebElement> seachList = Find.findElements(driver, new By.ById("com.ss.android.ugc.aweme:id/recycler_view"));
//        System.out.println(seachList.toString());
//        seachList
//        seachList.get(0).click();
        //  C:\Users\Dovis>adb connect 127.0.0.1:62001
        //connected to 127.0.0.1:62001
        //
        //C:\Users\Dovis>adb devices
        //List of devices attached
        //127.0.0.1:62001 device


    }

    public void seachUserClick(AndroidDriver driver) throws InterruptedException {
        boolean idEnd = true; // 是否加载所有用户
        int seachUserNum = 1;
        while (idEnd){
            Thread.sleep(5000);
            // com.ss.android.ugc.aweme:id/e-4
            // /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout
            WebElement webElement= Find.findElement(driver, new By.ById("com.ss.android.ugc.aweme:id/e-4"));
            List<WebElement> seachUserList = webElement.findElements(new By.ByClassName("android.widget.FrameLayout"));
            if (seachUserList.size() == 0){
                Find.findElement(driver,new By.ById("com.ss.android.ugc.aweme:id/k4g")).click();
            }else{
                if (seachUserList.size() < 9){
                    idEnd = false;
                    System.out.println("所有列表以获取完毕");
                }
                System.out.println("本次列表size："+seachUserList.size());
                for (int i = 0; i < seachUserList.size(); i++) {
                    System.out.println("正在获取"+seachUserNum);
                    seachUserNum += 1;
                    seachUserList.get(i).click();

                    System.out.println("模拟获取数据5秒");
                    Thread.sleep(10000);
                    System.out.println("back");
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                    Thread.sleep(5000);
//                driver.p
                }
            }
        }
    }

}
