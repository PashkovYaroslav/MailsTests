package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ResourceBundle;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LoginPageIua extends AbstractPage {

    public static final String USER_NAME_LOCATOR = "//*[@name='login']";
    public static final String PASSWORD_LOCATOR = "//*[@name='pass']";
    public static final String LOGIN_BUTTON_LOCATOR = "//form/p/input";

    @FindBy(xpath = USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    public LoginPageIua(WebDriver driver) {
        super(driver);
        driver.get(ResourceBundle.getBundle("config").getString("i.ua.url"));
    }

    public StartMailPageIua login(String userName, String password){
        userNameLocator.sendKeys(userName);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageIua(driver);
    }
}
