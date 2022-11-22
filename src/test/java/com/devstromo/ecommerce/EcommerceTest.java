package com.devstromo.ecommerce;

import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTest extends BaseTest {

    @Test(description = "Test Case in Filling the form details for shopping")
    public void fillFormTCTest() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))
            .sendKeys("Ale M");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']"))
            .click();
        driver.findElement(AppiumBy.id("android:id/text1"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']"))
            .click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
            .click();
    }

    @Test(description = "Verifying toast messages for error validations")
    public void verifyToastMessagesTCTest() throws InterruptedException {

        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']"))
            .click();
        driver.findElement(AppiumBy.id("android:id/text1"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']"))
            .click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
            .click();
        String toastErrorMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]"))
            .getAttribute("name");
        assertEquals("Please enter your name", toastErrorMessage);
    }

    @Test(description = "Test Case - Scrolling in product list example with Appium Android scroll")
    public void scrollingTCTest() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))
            .sendKeys("Ale M");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']"))
            .click();
        driver.findElement(AppiumBy.id("android:id/text1"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']"))
            .click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        int productCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"))
            .size();
        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"))
                .get(i)
                .getText();
            if (productName.equals("Jordan 6 Rings")) {
                driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"))
                    .get(i)
                    .click();
            }
        }
        String cartCount = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/counterText"))
            .getText();
        assertEquals("1", cartCount);
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"))
            .click();
    }

    @Test(description = "Testcase-Dynamically selecting Product by scanning list based on text")
    public void selectProductDynamicallyTCTest() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))
            .sendKeys("Ale M");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']"))
            .click();
        driver.findElement(AppiumBy.id("android:id/text1"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']"))
            .click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
            .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        int productCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"))
            .size();
        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"))
                .get(i)
                .getText();
            if (productName.equals("Jordan 6 Rings")) {
                driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"))
                    .get(i)
                    .click();
            }
        }
        String cartCount = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/counterText"))
            .getText();
        assertEquals("1", cartCount);
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"))
            .click();

        // avoid conflicting id com.androidsample.generalstore:id/productName
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        String lastPageProduct = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName"))
            .getText();
        assertEquals("Jordan 6 Rings", lastPageProduct);
    }
}
