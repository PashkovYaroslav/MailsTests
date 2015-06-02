package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class SentMailPageYandex extends AbstractPage {

    public static final String LATEST_SENT_MAIL = "(//div[@class='b-messages']/div[1]//span[@class='b-messages__from__text'])[2]";

    @FindBy(xpath = LATEST_SENT_MAIL)
    private WebElement latestSentMail;

    public SentMailPageYandex(WebDriver driver) {
        super(driver);
    }

    public String getLatestSentMail() {
        return latestSentMail.getText();
    }

    public StartMailPageYandex goToStartPage() {
        return new StartMailPageYandex(driver);
    }
}
