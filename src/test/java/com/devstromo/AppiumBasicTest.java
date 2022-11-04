package com.devstromo;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasicTest {

    @Test
    public void AppiumTest() throws MalformedURLException {
        // AndroidDriver
        // Appium code -> Appium Server -> Mobile
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("ANE LX3");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), null);

        //Actual automation
    }
}
