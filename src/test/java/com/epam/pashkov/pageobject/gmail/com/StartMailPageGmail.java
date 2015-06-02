package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.helper.WaiterHelper;
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
    public static final String LOGOUT_BUTTON_LOCATOR = "//a[contains(text(),'Выйти')]";
    public static final String DRAFT_PAGE_TITLE = "Черновики";
    public static final String INBOX_PAGE_TITLE = "Входящие";
    public static final String SENT_PAGE_TITLE = "Отправленные";

    @FindBy(xpath = DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public StartMailPageGmail(WebDriver driver) {
        super(driver);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPageGmail goToDraftPage() {
        wait.delay(3000);
        wait.waitVisibilityOf(driver,draftButton);
        draftButton.click();
        wait.waitTitleContains(driver, DRAFT_PAGE_TITLE);
        return new DraftMailPageGmail(driver);
    }

    public LetterPageGmail openNewLetterPage() {
        writeLetterButton.click();
        wait.delay(3000);
        return new LetterPageGmail(driver);
    }

    public SentMailPageGmail goToSentMailPage() {
        wait.waitTitleContains(driver, INBOX_PAGE_TITLE);
        sentButton.click();
        wait.waitTitleContains(driver, SENT_PAGE_TITLE);
        return new SentMailPageGmail(driver);
    }

    public void logout() {
        currentAccountText.click();
        wait.waitVisibilityOf(driver, logoutButtonLocator);
        logoutButtonLocator.click();
    }
}
