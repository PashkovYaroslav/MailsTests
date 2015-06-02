package com.epam.pashkov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yaroslav_Pashkov on 5/26/2015.
 */
public class WebBrowserFactory {
    public static WebDriver getWebDriver(String webDriverName) {
        switch (webDriverName) {
            case "Firefox": {
                return new FirefoxDriver();
            }
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
                return new ChromeDriver();
            }
            case "Opera": {
                System.setProperty("webdriver.opera.driver", "lib/operadriver.exe");
                return new OperaDriver();
            }
            case "IE": {
                System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
                return new InternetExplorerDriver();
            }

            default:{
                throw new IllegalArgumentException("Incorrect browser name "+ webDriverName);
            }
        }
    }
}
