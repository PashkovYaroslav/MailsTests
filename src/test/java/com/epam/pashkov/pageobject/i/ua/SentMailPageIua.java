package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.LoginPage;
import com.epam.pashkov.pageobject.SentMailPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class SentMailPageIua implements SentMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsIua.LATEST_SENT_MAIL)
    private WebElement latestSentMail;

    public SentMailPageIua(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLatestSentMail() {
        return latestSentMail.getText();
    }

    public LoginPage goToLoginPage() {
        return new LoginPageIua(driver);
    }

    public void checkContainsOfMessage(String recipient){
        Assert.assertTrue(this.getLatestSentMail().equals(recipient));
    }
}
