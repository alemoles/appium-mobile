package com.devstromo.ecommerce;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @Test
    public void browserWebsiteTest() {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']"))
            .click();
        driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
        String text = driver.findElement(By.cssSelector("a[href*='products/3']"))
            .getText();
        assertEquals(text, "Devops");
    }
}
