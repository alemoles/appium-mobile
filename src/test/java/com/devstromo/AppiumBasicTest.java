package com.devstromo;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AppiumBasicTest extends BaseTest {

    @Test
    public void WifiSettingsName() {
        //Actual automation
        // Xpath, id, accessibilityId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference"))
            .click();
        // tagName[@attribute='value']
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"))
            .click();
        driver.findElement(By.id("android:id/checkbox"))
            .click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"))
            .click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle"))
            .getText();
        assertEquals(alertTitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit"))
            .sendKeys("AleWifi");
        driver.findElements(AppiumBy.className("android.widget.Button"))
            .get(1)
            .click();
        //set wifi name
    }

    @Test
    public void LongPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views"))
            .click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"))
            .click();
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(element);
        String menuText = driver.findElement(AppiumBy.id("android:id/title"))
            .getText();
        assertEquals("Sample menu", menuText);
        assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());
    }
}
