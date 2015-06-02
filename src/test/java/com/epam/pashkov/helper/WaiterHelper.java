package com.epam.pashkov.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

/**
 * Created by Yaroslav_Pashkov on 6/2/2015.
 */
public class WaiterHelper {
    public static final long TIME_OUT = Long.parseLong(ResourceBundle.getBundle("config").getString("driver.time_out"));

    public static void waitVisibilityOf(WebDriver driver, WebElement webElement){
        getWaitDriver(driver).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitTitleContains(WebDriver driver, String title){
        getWaitDriver(driver).until(ExpectedConditions.titleContains(title));
    }

    private static WebDriverWait getWaitDriver(WebDriver driver) {
        return new WebDriverWait(driver, TIME_OUT);
    }

    public static void delay(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
