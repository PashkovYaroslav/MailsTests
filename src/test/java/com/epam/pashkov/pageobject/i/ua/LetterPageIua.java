package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LetterPageIua extends AbstractPage {

    public static final String TITLE_INPUT = "//input[@name='subject']";
    public static final String RECIPIENT_INPUT = ".//*[@id='to']";
    public static final String TEXT_INPUT = ".//*[@id='text']";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON = "//p[@class='send_container']/input[@name='save_in_drafts']";
    public static final String SEND_LETTER_BUTTON = "(//input[@name='send'])[1]";

    @FindBy(xpath = TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = RECIPIENT_INPUT)
    private WebElement recipientInput;

    @FindBy(xpath = TEXT_INPUT)
    private WebElement textInput;

    @FindBy(xpath = SAVE_LETTER_TO_DRAFT_BUTTON)
    private WebElement saveLetterToDraftButton;

    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    public String getTitle() {
        return titleInput.getAttribute("value");
    }

    public String getRecipient() {
        return recipientInput.getText();
    }

    public String getLetterText() {
        return textInput.getText();
    }

    public LetterPageIua(WebDriver driver) {
        super(driver);
    }

    public void createLetter(String title, String recipient, String text) {
        titleInput.sendKeys(title);
        recipientInput.sendKeys(recipient);
        textInput.sendKeys(text);
    }

    public StartMailPageIua saveLetterToDraft() {
        saveLetterToDraftButton.click();
        return new StartMailPageIua(driver);
    }

    public StartMailPageIua sendLetter() {
        sendLetterButton.click();
        return new StartMailPageIua(driver);
    }

    public void checkLetter(String recipient, String subject, String text){
        Assert.assertTrue(this.getTitle().equals(subject));
        Assert.assertTrue(this.getLetterText().equals(text));
        Assert.assertTrue(this.getRecipient().equals(recipient));
    }
}
