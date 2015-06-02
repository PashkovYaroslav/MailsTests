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
    public static final String PRE_LOGOUT_BUTTON = "(//span[@class='user__name'])[1]";
    public static final String LOGOUT_BUTTON_LOCATOR = "//div[@class='userlist__links']/a";

    @FindBy(xpath = USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    @FindBy(xpath = PRE_LOGOUT_BUTTON)
    private WebElement preLogoutButton;

    @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public LoginPageYandex(WebDriver driver) {
        super(driver);
        driver.get(ResourceBundle.getBundle("credentials").getString("yandex.ru.url"));
    }

    public StartMailPageYandex login(String userName, String password){
        userNameLocator.sendKeys(userName);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageYandex(driver);
    }

    public LoginPageYandex logout() {
        preLogoutButton.click();
        WaiterHelper.waitVisibilityOf(driver, logoutButtonLocator);
        logoutButtonLocator.click();
        return new LoginPageYandex(driver);
    }


}
