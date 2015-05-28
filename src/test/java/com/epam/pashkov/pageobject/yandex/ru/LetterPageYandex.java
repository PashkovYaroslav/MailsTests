package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsYandex;
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
public class LetterPageYandex implements LetterPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsYandex.TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = ConstantsYandex.RECIPIENT_INPUT)
    private WebElement recipientInput;

    @FindBy(xpath = ConstantsYandex.TEXT_INPUT)
    private WebElement textInput;

    @FindBy(xpath = ConstantsYandex.SAVE_LETTER_TO_DRAFT_BUTTON)
    private WebElement saveLetterToDraftButton;

    @FindBy(xpath = ConstantsYandex.SAVE_LETTER_TO_DRAFT_BUTTON_POPUP)
    private WebElement saveLetterToDraftButtonPopup;

    @FindBy(xpath = ConstantsYandex.SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    @FindBy(xpath = ConstantsYandex.INBOX_BUTTON)
    private  WebElement inboxButton;

    @FindBy(xpath = ConstantsYandex.SUCCESS_SEND_LETTER)
    private WebElement successSendLetter;

    public String getTitle() {
        return titleInput.getAttribute("value");
    }

    public String getRecipient() {
        return recipientInput.getAttribute("value");
    }

    public String getLetterText() {
        return textInput.getAttribute("value");
    }

    public LetterPageYandex(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createLetter(String title, String recipient, String text) {
        recipientInput.sendKeys(recipient);
        titleInput.sendKeys(title);
        textInput.sendKeys(text);
    }

    public StartMailPage saveLetterToDraft() {
        saveLetterToDraftButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(saveLetterToDraftButtonPopup));
        saveLetterToDraftButtonPopup.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Входящие"));
        return new StartMailPageYandex(driver);
    }

    public StartMailPage sendLetter() {
        sendLetterButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(successSendLetter));
        driver.get(driver.getCurrentUrl().replace("#done","#inbox"));
        //new WebDriverWait(driver, 25, 5000).until(ExpectedConditions.titleContains("Входящие"));
        return new StartMailPageYandex(driver);
    }

    public void checkLetter(String recipient, String subject, String text){
        String title1 = this.getTitle();
        String title2 = this.getLetterText();
        String title3 = this.getRecipient();
        Assert.assertTrue(this.getTitle().equals(subject));
        Assert.assertTrue(this.getLetterText().equals(text));
        Assert.assertTrue(this.getRecipient().equals(recipient));
    }
}
