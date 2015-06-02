package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.helper.WaiterHelper;
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
            WaiterHelper.delay(3000);
            driver.findElement(By.xpath(LATEST_MESSAGE));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public LetterPageYandex openLatestLetter() {
        WaiterHelper.waitTitleContains(driver,"Черновики");
        latestMessage.click();
        WaiterHelper.waitTitleContains(driver, "Сохраненное");
        return new LetterPageYandex(driver);
    }

    public StartMailPageYandex openStartMailPage() {
        inboxButton.click();
        WaiterHelper.waitTitleContains(driver, "Входящие");
        return new StartMailPageYandex(driver);
    }
}
