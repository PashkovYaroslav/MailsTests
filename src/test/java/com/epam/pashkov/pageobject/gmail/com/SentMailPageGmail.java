package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.LoginPage;
import com.epam.pashkov.pageobject.SentMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsGmail;
import com.epam.pashkov.pageobject.constants.ConstantsYandex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class SentMailPageGmail implements SentMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsGmail.LATEST_SENT_MAIL)
    private WebElement latestSentMail;

    public SentMailPageGmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLatestSentMail() {
        return latestSentMail.getText();
    }

    public LoginPage goToLoginPage() {
        return new LoginPageGmail(driver);
    }

    public void checkContainsOfMessage(String recipient){
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        Assert.assertTrue(this.getLatestSentMail().equals(recipient));
    }
}
