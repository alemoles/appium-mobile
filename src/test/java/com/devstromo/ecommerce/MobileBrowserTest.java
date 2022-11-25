package com.devstromo.ecommerce;

import static org.openqa.selenium.Keys.ENTER;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class MobileBrowserTest extends BrowserBaseTest {

    @Test
    public void browserTest() {
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(AppiumBy.name("q"))
            .sendKeys("rahul shetty academy");
        driver.findElement(AppiumBy.name("q"))
            .sendKeys(ENTER);
    }
}
