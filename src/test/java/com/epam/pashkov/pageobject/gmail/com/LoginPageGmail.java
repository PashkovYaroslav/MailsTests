package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.helper.WaiterHelper;
import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LoginPageGmail extends AbstractPage {

    public static final String USER_NAME_LOCATOR = ".//input[@id='Email']";
    public static final String NEXT_BUTTON = ".//input[@id='next']";
    public static final String PASSWORD_LOCATOR = ".//*[@id='Passwd']";
    public static final String LOGIN_BUTTON_LOCATOR = ".//*[@id='signIn']";
    public static final String LOGOUT_BUTTON_LOCATOR = "//a[contains(text(),'Выйти')]";
    public static final String CURRENT_ACCOUNT_TEXT = ".//*[@id='gb']//a[contains(@class,'gb_ga') and contains(@title,'Аккаунт')]";


    @FindBy(xpath = USER_NAME_LOCATOR)
    private WebElement userNameLocator;

    @FindBy(xpath = CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = NEXT_BUTTON)
    private WebElement nextButton;

    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public LoginPageGmail(WebDriver driver) {
        super(driver);
        driver.get(ResourceBundle.getBundle("credentials").getString("gmail.com.url"));
    }

    public StartMailPageGmail login(String userName, String password){
        userNameLocator.sendKeys(userName);
        nextButton.click();
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        return new StartMailPageGmail(driver);
    }

    public void logout() {
        currentAccountText.click();
        WaiterHelper.waitVisibilityOf(driver,logoutButtonLocator);
        logoutButtonLocator.click();
    }


}
