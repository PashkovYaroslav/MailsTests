package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsGmail;
import com.thoughtworks.selenium.SeleniumException;
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
public class LetterPageGmail implements LetterPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsGmail.TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = ConstantsGmail.RECIPIENT_INPUT)
    private WebElement recipientInput;

    @FindBy(xpath = ConstantsGmail.RECIPIENT_LIST)
    private WebElement recipientList;

    @FindBy(xpath = ConstantsGmail.TEXT_INPUT)
    private WebElement textInput;

    @FindBy(xpath = ConstantsGmail.SAVE_LETTER_TO_DRAFT_BUTTON)
    private WebElement saveLetterToDraftButton;

    @FindBy(xpath = ConstantsGmail.SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    @FindBy(xpath = ConstantsGmail.INBOX_BUTTON)
    private WebElement inboxButton;

    @FindBy(xpath = ConstantsGmail.RECIPIENT_UI)
    private WebElement recipientUi;

    @FindBy(xpath = ConstantsGmail.SUBJECT_UI)
    private WebElement subjectUi;

    public String getTitle() {
        return titleInput.getAttribute("value");
    }

    public String getRecipient() {
        return recipientList.getText();
    }

    public String getLetterText() {
        return textInput.getText();
    }

    public LetterPageGmail(WebDriver driver) {
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
        new WebDriverWait(driver, 15, 5000);
        return new StartMailPageGmail(driver);
    }

    public StartMailPage sendLetter() {
        sendLetterButton.click();
        new WebDriverWait(driver, 15, 8000);
        //new WebDriverWait(driver, 15, 5000).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Письмо отправлено.']"))));

        inboxButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleContains("Входящие"));
        new WebDriverWait(driver, 15, 6000);
        return new StartMailPageGmail(driver);
    }

    public void checkLetter(String recipient, String subject, String text){
        /*Assert.assertTrue(this.getRecipient().equals(recipient));
        Assert.assertTrue(this.getTitle().equals(subject));
        Assert.assertTrue(this.getLetterText().equals(text));*/
        Assert.assertTrue(this.recipientUi.getText().equals(recipient));
        Assert.assertTrue(this.subjectUi.getAttribute("value").equals(subject));
        Assert.assertTrue(this.getLetterText().equals(text));
    }
}
