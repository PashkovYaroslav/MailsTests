package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class DraftMailPageIua extends AbstractPage {

    public static final String LATEST_MESSAGE = ".//*[@id='mesgList']//a/span[2]";

    @FindBy(xpath = LATEST_MESSAGE)
    private WebElement latestMessage;

    public DraftMailPageIua(WebDriver driver) {
        super(driver);
    }

    public boolean getLatestLetter() {
        try {
            driver.findElement(By.xpath(LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPageIua openLatestLetter() {
        latestMessage.click();
        return new LetterPageIua(driver);
    }

    public StartMailPageIua openStartMailPage() {
        return new StartMailPageIua(driver);
    }
}
