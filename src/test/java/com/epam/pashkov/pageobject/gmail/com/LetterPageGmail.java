package com.epam.pashkov.pageobject.gmail.com;

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
public class LetterPageGmail extends AbstractPage {

    public static final String INBOX_BUTTON = "//a[contains(text(),'Входящие')]";
    public static final String TITLE_INPUT = "//input[@name='subjectbox']";
    public static final String RECIPIENT_INPUT = "//textarea[@aria-label='Кому']";
    public static final String RECIPIENT_LIST = "//form//span[@email]/div[1]";
    public static final String TEXT_INPUT = "//div[@aria-label='Тело письма']";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON = "//img[@alt='Закрыть']";
    public static final String SEND_LETTER_BUTTON = "//div[text()='Отправить']";
    public static final String RECIPIENT_UI = "//div[@tabindex='1']//span[@email]";
    public static final String SUBJECT_UI = "//input[@name='subjectbox']";

    @FindBy(xpath = TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = RECIPIENT_INPUT)
    private WebElement recipientInput;

    @FindBy(xpath = RECIPIENT_LIST)
    private WebElement recipientList;

    @FindBy(xpath = TEXT_INPUT)
    private WebElement textInput;

    @FindBy(xpath = SAVE_LETTER_TO_DRAFT_BUTTON)
    private WebElement saveLetterToDraftButton;

    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    @FindBy(xpath = INBOX_BUTTON)
    private WebElement inboxButton;

    @FindBy(xpath = RECIPIENT_UI)
    private WebElement recipientUi;

    @FindBy(xpath = SUBJECT_UI)
    private WebElement subjectUi;

    public String getTitle() {
        return titleInput.getAttribute("value");
    }

    public String getRecipient() {
        return recipientList.getAttribute("innerHTML");
    }

    public String getLetterText() {
        return textInput.getText();
    }

    public LetterPageGmail(WebDriver driver) {
        super(driver);
    }

    public void createLetter(String title, String recipient, String text) {
        recipientInput.sendKeys(recipient);
        titleInput.sendKeys(title);
        textInput.sendKeys(text);
    }

    public StartMailPageGmail saveLetterToDraft() {
        saveLetterToDraftButton.click();
        return new StartMailPageGmail(driver);
    }

    public StartMailPageGmail sendLetter() {
        sendLetterButton.click();
        WaiterHelper.delay(3000);
        inboxButton.click();
        WaiterHelper.waitTitleContains(driver,"Входящие");
        return new StartMailPageGmail(driver);
    }
}
