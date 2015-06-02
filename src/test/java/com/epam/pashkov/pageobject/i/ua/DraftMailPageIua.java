package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.MailTest;
import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class DraftMailPageIua extends AbstractPage {

    public static final String DRAFT_MESSAGES = ".//*[@id='mesgList']//a/span[3]/span";

    @FindBy(xpath = DRAFT_MESSAGES)
    private List<WebElement> draftMessages;

    public DraftMailPageIua(WebDriver driver) {
        super(driver);
    }

    public boolean hasLatestLetter() {
        wait.delay(3000);
        for(int i = 0; i< draftMessages.size(); i++){
            if(draftMessages.get(i).getText().equals(MailTest.TITLE)){
                latestMessageWebElement = draftMessages.get(i);
                return true;
            }
        }
        return false;
    }

    public LetterPageIua openLatestLetter() {
        latestMessageWebElement.click();
        return new LetterPageIua(driver);
    }

    public StartMailPageIua openStartMailPage() {
        return new StartMailPageIua(driver);
    }
}
