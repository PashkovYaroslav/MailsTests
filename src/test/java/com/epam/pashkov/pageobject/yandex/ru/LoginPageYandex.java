package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.LoginPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsYandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LoginPageYandex implements LoginPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsYandex.USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = ConstantsYandex.PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = ConstantsYandex.LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    @FindBy(xpath = ConstantsYandex.PRE_LOGOUT_BUTTON)
    private WebElement preLogoutButton;

    @FindBy(xpath = ConstantsYandex.LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public LoginPageYandex(WebDriver driver) {
        this.driver = driver;
        driver.get("http://www.yandex.ua/");
        PageFactory.initElements(driver, this);
    }

    public StartMailPage login(String userName, String password){
        userNameLocator.sendKeys(userName);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageYandex(driver);
    }

    public LoginPage logout() {
        preLogoutButton.click();
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.visibilityOf(logoutButtonLocator));
        logoutButtonLocator.click();
        return new LoginPageYandex(driver);
    }


}
