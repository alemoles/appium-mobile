package com.devstromo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureApp() throws MalformedURLException {
        Path resourceDirectory = Paths.get("src", "test", "resources");
        File file = new File(resourceDirectory + "/ApiDemos-debug.apk");
        String basePath = System.getenv("APPDATA")
            .replace("\\", "//");
        // AndroidDriver
        // Appium code -> Appium Server -> Mobile
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus 5 API 24");
        options.setApp(file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        service = new AppiumServiceBuilder().withAppiumJS(new File(basePath + "//npm//node_modules//appium//build//lib//main.js"))
            .withIPAddress("127.0.0.1")
            .usingPort(4723)
            .build();
        //start server
        service.start();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        // stop server
        service.stop();
    }
}
