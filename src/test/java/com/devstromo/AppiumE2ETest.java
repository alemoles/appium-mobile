package com.devstromo;

import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumE2ETest extends BaseTest {

    @Test
    public void clickOkOnDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons"))
            .click();
        String title = driver.findElement(AppiumBy.id("android:id/alertTitle"))
            .getText();
        assertEquals("Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.", title);
        driver.findElement(AppiumBy.id("android:id/button1"))
            .click();
    }

    @Test
    public void clickSomethingOnLongMessageDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons2"))
            .click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/button3"));
        assertEquals("SOMETHING", element.getText());
        element.click();
    }

    @Test
    public void scrollAndClickSomethingOnUltraLongMessageDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons2ultra"))
            .click();
        //scroll
        scrollToEndAction();
        WebElement element = driver.findElement(AppiumBy.id("android:id/button3"));
        assertEquals("SOMETHING", element.getText());
        element.click();
    }

    @Test
    @Ignore
    public void waitUntilProgressEndAndClickCancelOnProgressDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/progress_button"))
            .click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //        wait.until(ExpectedConditions.presenceOfElementLocated());
    }

    @Test
    public void selectElementAndClickOkOnSingleChoiceListDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/radio_button"))
            .click();
        WebElement secondElement = driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]"));
        assertEquals("false", driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[2]"))
            .getAttribute("checked"));
        secondElement.click();
        assertEquals("true", driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[2]"))
            .getAttribute("checked"));
        driver.findElement(AppiumBy.id("android:id/button1"))
            .click();
    }

    @Test
    public void checkElementsAndClickMultipleTimeOkOnRepeatAlarmDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/checkbox_button"))
            .click();
        WebElement secondElement = driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]"));
        assertEquals("true", driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[2]"))
            .getAttribute("checked"));
        secondElement.click();
        assertEquals("false", driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[2]"))
            .getAttribute("checked"));
        assertEquals("false", driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[6]"))
            .getAttribute("checked"));
        WebElement sixElement = driver.findElement(By.xpath("(//android.widget.CheckedTextView)[6]"));
        sixElement.click();
        assertEquals("true", driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[6]"))
            .getAttribute("checked"));
        driver.findElement(AppiumBy.id("android:id/button1"))
            .click();
    }

    @Test
    public void entryUserAndPasswordAndClickOkOnRepeatAlarmDialogAction() {
        driver.findElement(AppiumBy.accessibilityId("App"))
            .click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs"))
            .click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/text_entry_button"))
            .click();

        WebElement entryName = driver.findElement(By.id("io.appium.android.apis:id/username_edit"));
        assertEquals(0, entryName.getText()
            .length());
        entryName.sendKeys("Username");
        assertEquals("Username", entryName.getText());
        WebElement password = driver.findElement(By.id("io.appium.android.apis:id/password_edit"));
        assertEquals(0, password.getText()
            .length());
        password.sendKeys("Password");
        assertEquals(8, password.getText()
            .length());
        driver.findElement(AppiumBy.id("android:id/button1"))
            .click();
    }
}
