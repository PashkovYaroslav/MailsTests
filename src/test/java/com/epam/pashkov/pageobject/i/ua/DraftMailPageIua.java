package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.DraftMailPage;
import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
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
public class DraftMailPageIua implements DraftMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsIua.LATEST_MESSAGE)
    private WebElement latestMessage;

    public DraftMailPageIua(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean getLatestLetter() {
        try {
            driver.findElement(By.xpath(ConstantsIua.LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPage openLatestLetter() {
        latestMessage.click();
        return new LetterPageIua(driver);
    }

    public StartMailPage openStartMailPage() {
        return new StartMailPageIua(driver);
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
