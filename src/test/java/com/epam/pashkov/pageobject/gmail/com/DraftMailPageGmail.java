package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.AbstractPage;
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
public class DraftMailPageGmail extends AbstractPage {

    public static final String LATEST_MESSAGE = "(//td[@tabindex='-1']/div[@role='link']//span[1])[2]";
    public static final String INBOX_BUTTON = "//a[contains(text(),'Входящие')]";

    @FindBy(xpath = LATEST_MESSAGE)
    private WebElement latestMessage;

    @FindBy(xpath = INBOX_BUTTON)
    private WebElement inboxButton;

    public DraftMailPageGmail(WebDriver driver) {
        super(driver);
    }

    public boolean getLatestLetter() {
        try {
            new WebDriverWait(driver, 5).withTimeout(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath(LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPageGmail openLatestLetter() {
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        latestMessage.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LetterPageGmail(driver);
    }

    public StartMailPageGmail openStartMailPage() {
        inboxButton.click();
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Входящие"));
        return new StartMailPageGmail(driver);
    }

    public void checkContainsOfMessage(boolean expected){
        try {
            if (expected) {
                Assert.assertTrue(this.getLatestLetter());
            } else {
                Assert.assertFalse(this.getLatestLetter());
            }
        }
        catch (AssertionError e){
            System.out.println("Some drafts found.");
        }
    }
}
