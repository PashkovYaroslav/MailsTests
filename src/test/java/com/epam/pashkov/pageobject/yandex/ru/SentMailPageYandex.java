package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.LoginPage;
import com.epam.pashkov.pageobject.SentMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
import com.epam.pashkov.pageobject.constants.ConstantsYandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class SentMailPageYandex implements SentMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsYandex.LATEST_SENT_MAIL)
    private WebElement latestSentMail;

    public SentMailPageYandex(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLatestSentMail() {
        return latestSentMail.getText();
    }

    public LoginPage goToLoginPage() {
        return new LoginPageYandex(driver);
    }

    public void checkContainsOfMessage(String recipient){
        Assert.assertTrue(this.getLatestSentMail().equals(recipient));
    }
}
