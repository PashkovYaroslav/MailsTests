package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.DraftMailPage;
import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
import com.epam.pashkov.pageobject.constants.ConstantsYandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class DraftMailPageYandex implements DraftMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsYandex.LATEST_MESSAGE)
    private WebElement latestMessage;

    @FindBy(xpath = ConstantsYandex.INBOX_BUTTON)
    private WebElement inboxButton;

    public DraftMailPageYandex(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean getLatestLetter() {
        try {
            new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath(ConstantsYandex.LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPage openLatestLetter() {
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        latestMessage.click();
        return new LetterPageYandex(driver);
    }

    public StartMailPage openStartMailPage() {
        inboxButton.click();
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Входящие"));
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
