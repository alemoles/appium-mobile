package com.devstromo;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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
        //set wifi name
        driver.findElement(By.id("android:id/edit"))
            .sendKeys("AleWifi");
        driver.findElements(AppiumBy.className("android.widget.Button"))
            .get(1)
            .click();
    }

    @Test
    public void LongPressGesture() {
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
        assertTrue(driver.findElement(AppiumBy.id("android:id/title"))
            .isDisplayed());
    }

    @Test
    public void ScrollDemoTest() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"));
        driver.findElement(AppiumBy.accessibilityId("Views"))
            .click();
        // where to scroll is known prior
        // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        // not prior idea
        scrollToEndAction();
    }

    @Test
    public void SwipeDemoTest() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"));
        driver.findElement(AppiumBy.accessibilityId("Views"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gallery\"));"));
        driver.findElement(AppiumBy.accessibilityId("Gallery"))
            .click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']"))
            .click();

        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        assertEquals("true", driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"))
            .getAttribute("focusable"));
        // Swipe
        swipeAction(firstImage, "left");

        assertEquals("false", driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"))
            .getAttribute("focusable"));
    }

    @Test
    public void DragDropTest() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"));
        driver.findElement(AppiumBy.accessibilityId("Views"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop"))
            .click();
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
            ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", 739, "endY", 633));
        Thread.sleep(3000);
        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text"))
            .getText();
        assertEquals("Dropped!", result);
    }
}
