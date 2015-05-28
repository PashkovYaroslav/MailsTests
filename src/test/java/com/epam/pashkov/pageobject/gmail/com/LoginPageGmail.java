package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.LoginPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsGmail;
import com.epam.pashkov.pageobject.constants.ConstantsYandex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LoginPageGmail implements LoginPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsGmail.USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = ConstantsGmail.CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = ConstantsGmail.NEXT_BUTTON)
    private WebElement nextButton;

    @FindBy(xpath = ConstantsGmail.PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = ConstantsGmail.LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    @FindBy(xpath = ConstantsGmail.LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public LoginPageGmail(WebDriver driver, boolean url) {
        this.driver = driver;
        if(url) {
            driver.get("http://gmail.com/");
        }
        PageFactory.initElements(driver, this);
    }

    public StartMailPage login(String userName, String password){
        userNameLocator.sendKeys(userName);
        nextButton.click();
        //new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.visibilityOf(passwordLocator));
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageGmail(driver);
    }

    public LoginPage logout() {
        currentAccountText.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(logoutButtonLocator));
        logoutButtonLocator.click();
        return new LoginPageGmail(driver,true);
    }


}
