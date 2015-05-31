package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LetterPageYandex extends AbstractPage {

    public static final String INBOX_BUTTON = "//div[@class='b-folders__i']/div[1]/span[2]/a";
    public static final String TITLE_INPUT = "//*[@id='compose-subj']";
    public static final String RECIPIENT_INPUT = "(//div[contains(@class,'b-mail-input_yabbles')]//input[contains(@class,'b-yabble__input')])";
    public static final String TEXT_INPUT = "//*[@id='compose-send']";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON = "(//button[contains(@id,'nb')])[4]";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON_POPUP = "//div[@class='b-popup__confirm']/button[1]";
    public static final String SEND_LETTER_BUTTON = "(//button[contains(@id,'nb')])[1]";
    public static final String SUCCESS_SEND_LETTER = "//span[contains(text(),'Письмо успешно')]";

    @FindBy(xpath = TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = RECIPIENT_INPUT)
    private WebElement recipientInput;

    @FindBy(xpath = TEXT_INPUT)
    private WebElement textInput;

    @FindBy(xpath = SAVE_LETTER_TO_DRAFT_BUTTON)
    private WebElement saveLetterToDraftButton;

    @FindBy(xpath = SAVE_LETTER_TO_DRAFT_BUTTON_POPUP)
    private WebElement saveLetterToDraftButtonPopup;

    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    @FindBy(xpath = INBOX_BUTTON)
    private  WebElement inboxButton;

    @FindBy(xpath = SUCCESS_SEND_LETTER)
    private WebElement successSendLetter;

    public String getTitle() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(titleInput));
        return titleInput.getAttribute("value");
    }

    public String getRecipient() {
        return recipientInput.getAttribute("value");
    }

    public String getLetterText() {
        return textInput.getAttribute("value");
    }

    public LetterPageYandex(WebDriver driver) {
        super(driver);
    }

    public void createLetter(String title, String recipient, String text) {
        recipientInput.sendKeys(recipient);
        titleInput.sendKeys(title);
        textInput.sendKeys(text);
    }

    public StartMailPageYandex saveLetterToDraft() {
        saveLetterToDraftButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(saveLetterToDraftButtonPopup));
        saveLetterToDraftButtonPopup.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Входящие"));
        return new StartMailPageYandex(driver);
    }

    public StartMailPageYandex sendLetter() {
        sendLetterButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(successSendLetter));
        driver.get(driver.getCurrentUrl().replace("#done","#inbox"));
        //new WebDriverWait(driver, 25, 5000).until(ExpectedConditions.titleContains("Входящие"));
        return new StartMailPageYandex(driver);
    }

    public void checkLetter(String recipient, String subject, String text){
        Assert.assertTrue(this.getTitle().equals(subject));
        Assert.assertTrue(this.getLetterText().equals(text));
        Assert.assertTrue(this.getRecipient().equals(recipient));
    }
}
