package com.anshapro.utils;

import io.appium.mitmproxy.InterceptedMessage;
import io.appium.mitmproxy.MitmproxyJava;
import org.apache.http.HttpHost;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DouyinDataLister {
    static String localUrl = "C:/Program Files (x86)/mitmproxy/bin/mitmdump.exe";
    @Test
    public void init() throws IOException, URISyntaxException, TimeoutException, InterruptedException {
        MitmproxyJava proxy;
        List<InterceptedMessage> messages = new ArrayList<InterceptedMessage>();

//optional, default port is 8080
        int mitmproxyPort = 8888;

//optional, you can pass null if no extra params
        List<String> extraMitmproxyParams = Arrays.asList("param1", "value1", "param2", "value2");

// remember to set local OS proxy settings in the Network Preferences
        proxy = new MitmproxyJava(localUrl, (InterceptedMessage m) -> {
            System.out.println("intercepted request for " + m.requestURL.toString());
            messages.add(m);
            return m;
        });

        proxy.start();

        Thread.sleep(10000);
        for(InterceptedMessage interceptedMessage : messages){
            System.out.println(interceptedMessage.requestURL);
        }

// do stuff

        proxy.stop();
    }

//    @Test
//    public void SimpleTest() throws InterruptedException, TimeoutException, IOException, URISyntaxException {
//        List<InterceptedMessage> messages = new ArrayList<>();
//
//        MitmproxyJava proxy = new MitmproxyJava(localUrl, (InterceptedMessage m) -> {
//            messages.add(m);
//            return m;
//        });
//        proxy.start();
//
//        Unirest.setProxy(new HttpHost("localhost", 8080));
//        Unirest.get("http://appium.io").header("myTestHeader", "myTestValue").asString();
//
//        proxy.stop();
//        final InterceptedMessage firstMessage = messages.get(0);
//
//        assertThat(firstMessage.getRequest().getUrl()).startsWith("http://appium.io");
//        assertThat(firstMessage.getRequest().getHeaders()).containsOnlyOnce(new String[]{"myTestHeader", "myTestValue"});
//        assertThat(firstMessage.getResponse().getStatusCode()).isEqualTo(200);
//    }
}
