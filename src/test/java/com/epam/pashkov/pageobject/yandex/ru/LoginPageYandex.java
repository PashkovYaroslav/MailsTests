package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.helper.WaiterHelper;
import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LoginPageYandex extends AbstractPage {

    public static final String USER_NAME_LOCATOR = ".//input[@name='login']";
    public static final String PASSWORD_LOCATOR = "//input[@name='passwd']";
    public static final String LOGIN_BUTTON_LOCATOR = "//div[@class='auth__button']/button";


    @FindBy(xpath = USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    public LoginPageYandex(WebDriver driver) {
        super(driver);
        driver.get(ResourceBundle.getBundle("config").getString("yandex.ru.url"));
    }

    public StartMailPageYandex login(String userName, String password){
        userNameLocator.sendKeys(userName);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageYandex(driver);
    }
}
