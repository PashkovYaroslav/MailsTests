package com.epam.pashkov;

import com.epam.pashkov.helper.WaiterHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav_Pashkov on 6/2/2015.
 */
public class BaseTest {
    protected WebDriver driver;
    protected ResourceBundle config;

    @BeforeTest
    public void preconditions(){
        config = ResourceBundle.getBundle("config");
        driver = WebBrowserFactory.getWebDriver(config.getString("driver"));
        driver.manage().timeouts().implicitlyWait(WaiterHelper.TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void postconditions(){
        driver.quit();
    }
}
