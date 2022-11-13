package com.devstromo;

import static org.testng.AssertJUnit.assertNotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasicTest {

    @Test
    public void AppiumTest() throws MalformedURLException {
        Path resourceDirectory = Paths.get("src", "test", "resources");
        File file = new File(resourceDirectory + "/ApiDemos-debug.apk");

        //start server
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(
                new File("C://Users//Alejamdro//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
            .withIPAddress("127.0.0.1")
            .usingPort(4723)
            .build();
        service.start();
        // AndroidDriver
        // Appium code -> Appium Server -> Mobile
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus 5 API 24");
        options.setApp(file.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        //Actual automation
        driver.quit();
        // stop server
        service.stop();
    }
}
