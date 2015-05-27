package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class LetterPageIua implements LetterPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsIua.TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = ConstantsIua.RECIPIENT_INPUT)
    private WebElement recipientInput;

    @FindBy(xpath = ConstantsIua.TEXT_INPUT)
    private WebElement textInput;

    @FindBy(xpath = ConstantsIua.SAVE_LETTER_TO_DRAFT_BUTTON)
    private WebElement saveLetterToDraftButton;

    @FindBy(xpath = ConstantsIua.SEND_LETTER_BUTTON)
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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createLetter(String title, String recipient, String text) {
        titleInput.sendKeys(title);
        recipientInput.sendKeys(recipient);
        textInput.sendKeys(text);
    }

    public StartMailPage saveLetterToDraft() {
        saveLetterToDraftButton.click();
        return new StartMailPageIua(driver);
    }

    public StartMailPage sendLetter() {
        sendLetterButton.click();
        return new StartMailPageIua(driver);
    }

    public void checkLetter(String recipient, String subject, String text){
        Assert.assertTrue(this.getTitle().equals(subject));
        Assert.assertTrue(this.getLetterText().equals(text));
        Assert.assertTrue(this.getRecipient().equals(recipient));
    }
}
