package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class DraftMailPageYandex extends AbstractPage {

    public static final String LATEST_MESSAGE = "(//div[@class='b-messages']/div[1]//span[@class='b-messages__from__text'])[2]";
    public static final String INBOX_BUTTON = "//div[@class='b-folders__i']/div[1]/span[2]/a";

    @FindBy(xpath = LATEST_MESSAGE)
    private WebElement latestMessage;

    @FindBy(xpath = INBOX_BUTTON)
    private WebElement inboxButton;

    public DraftMailPageYandex(WebDriver driver) {
        super(driver);
    }

    public boolean getLatestLetter() {
        try {
            new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath(LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPageYandex openLatestLetter() {
        new WebDriverWait(driver, 5).withTimeout(5,TimeUnit.SECONDS);
        latestMessage.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Сохраненное"));
        return new LetterPageYandex(driver);
    }

    public StartMailPageYandex openStartMailPage() {
        inboxButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
        return new StartMailPageYandex(driver);
    }

    public void checkContainsOfMessage(boolean expected){
        if(expected) {
            Assert.assertTrue(this.getLatestLetter());
        }
        else{
            Assert.assertFalse(this.getLatestLetter());
        }
    }
}
