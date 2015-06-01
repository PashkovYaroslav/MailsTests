package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class StartMailPageGmail extends AbstractPage {

    public static final String DRAFT_BUTTON = "//a[contains(text(),'Черновики')]";
    public static final String SENT_BUTTON = "//a[contains(text(),'Отправленные')]";
    public static final String CURRENT_ACCOUNT_TEXT = ".//*[@id='gb']//a[contains(@class,'gb_ga') and contains(@title,'Аккаунт')]";
    public static final String WRITE_LETTER_BUTTON = "//div[text()='НАПИСАТЬ']";

    @FindBy(xpath = DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    public StartMailPageGmail(WebDriver driver) {
        super(driver);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPageGmail goToDraftPage() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(draftButton));
        draftButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Черновики"));
        return new DraftMailPageGmail(driver);
    }

    public LetterPageGmail openNewLetterPage() {
        writeLetterButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LetterPageGmail(driver);
    }

    public SentMailPageGmail goToSentMailPage() {
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Входящие"));
        sentButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Отправленные"));
        return new SentMailPageGmail(driver);
    }
}
