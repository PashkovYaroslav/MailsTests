package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class SentMailPageGmail extends AbstractPage {

    public static final String LATEST_SENT_MAIL = "(//tr[@aria-labelledby]/td[4]//span[@name])[7]";

    @FindBy(xpath = LATEST_SENT_MAIL)
    private WebElement latestSentMail;

    public SentMailPageGmail(WebDriver driver) {
        super(driver);
    }

    public String getLatestSentMail() {
        return latestSentMail.getAttribute("innerHTML");
    }

    public LoginPageGmail goToLoginPage() {
        return new LoginPageGmail(driver);
    }
}
