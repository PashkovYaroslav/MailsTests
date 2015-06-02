package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class DraftMailPageYandex extends AbstractPage {

    public static final String LATEST_MESSAGE = "(//div[@class='b-messages']/div[1]//span[@class='b-messages__from__text'])[2]";
    public static final String INBOX_BUTTON = "//div[@class='b-folders__i']/div[1]/span[2]/a";
    public static final String DRAFT_PAGE_TITLE = "Черновики";
    public static final String SAVED_MESSAGE = "Сохраненное";
    public static final String INBOX_PAGE_TITLE = "Входящие";

    @FindBy(xpath = LATEST_MESSAGE)
    private WebElement latestMessage;

    @FindBy(xpath = INBOX_BUTTON)
    private WebElement inboxButton;

    public DraftMailPageYandex(WebDriver driver) {
        super(driver);
    }

    public boolean hasLatestLetter() {
        try {
            wait.delay(3000);
            driver.findElement(By.xpath(LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPageYandex openLatestLetter() {
        wait.waitTitleContains(driver, DRAFT_PAGE_TITLE);
        latestMessage.click();
        wait.waitTitleContains(driver, SAVED_MESSAGE);
        return new LetterPageYandex(driver);
    }

    public StartMailPageYandex openStartMailPage() {
        inboxButton.click();
        wait.waitTitleContains(driver, INBOX_PAGE_TITLE);
        return new StartMailPageYandex(driver);
    }
}
