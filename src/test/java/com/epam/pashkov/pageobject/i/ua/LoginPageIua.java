package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.LoginPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LoginPageIua implements LoginPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsIua.USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = ConstantsIua.PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = ConstantsIua.LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    @FindBy(xpath = ConstantsIua.LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public LoginPageIua(WebDriver driver) {
        this.driver = driver;
        driver.get("http://www.i.ua/");
        PageFactory.initElements(driver, this);
    }

    public StartMailPage login(String userName, String password){
        userNameLocator.sendKeys(userName);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageIua(driver);
    }

    public LoginPage logout() {
        logoutButtonLocator.click();
        return new LoginPageIua(driver);
    }


}
