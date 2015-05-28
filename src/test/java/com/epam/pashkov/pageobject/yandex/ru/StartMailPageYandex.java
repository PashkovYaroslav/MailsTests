package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.DraftMailPage;
import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.SentMailPage;
import com.epam.pashkov.pageobject.StartMailPage;
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
public class StartMailPageYandex implements StartMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsYandex.DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = ConstantsYandex.SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = ConstantsYandex.CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = ConstantsYandex.WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    public StartMailPageYandex(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPage goToDraftPage() {
        draftButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Черновики"));
        return new DraftMailPageYandex(driver);
    }

    public LetterPage openNewLetterPage() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Входящие"));
        writeLetterButton.click();
        return new LetterPageYandex(driver);
    }

    public SentMailPage goToSentMailPage() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Входящие"));
        sentButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Отправленные"));
        return new SentMailPageYandex(driver);
    }

    public void checkCurrentAccount(String account){
        Assert.assertTrue(this.getCurrentAccount().equals(account));
    }
}
