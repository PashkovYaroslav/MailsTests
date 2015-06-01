package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class SentMailPageIua extends AbstractPage {

    public static final String LATEST_SENT_MAIL = ".//*[@id='mesgList']//a/span[2]";

    @FindBy(xpath = LATEST_SENT_MAIL)
    private WebElement latestSentMail;

    public SentMailPageIua(WebDriver driver) {
        super(driver);
    }

    public String getLatestSentMail() {
        return latestSentMail.getText();
    }

    public LoginPageIua goToLoginPage() {
        return new LoginPageIua(driver);
    }
}
