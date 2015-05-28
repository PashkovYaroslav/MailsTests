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
 * Created by Yaroslav_Pashkov on 5/28/2015.
 */
public class WebBrowserFactory {
    public static WebDriver getWebDriver(WebDriverEnum webDriverEnum) {
        switch (webDriverEnum) {
            case FIREFOX: {
                String firebugPath = "lib/firebug-2.0.9-fx.xpi";
                FirefoxProfile profile = new FirefoxProfile();
                try {
                    profile.addExtension(new File(firebugPath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new FirefoxDriver(profile);
            }
            case CHROME: {
                System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
                return new ChromeDriver();
            }
            case OPERA: {
                System.setProperty("webdriver.opera.driver", "lib/operadriver.exe");
                return new OperaDriver();
            }
            case IE: {
                System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
                return new InternetExplorerDriver();
            }
        }
        return new FirefoxDriver();
    }
}