package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.*;
import com.epam.pashkov.pageobject.constants.ConstantsIua;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class StartMailPageIua implements StartMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsIua.DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = ConstantsIua.SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = ConstantsIua.CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = ConstantsIua.WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    public StartMailPageIua(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPage goToDraftPage() {
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        draftButton.click();
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        return new DraftMailPageIua(driver);
    }

    public LetterPage openNewLetterPage() {
        //new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        writeLetterButton.click();
        new WebDriverWait(driver, 15, 5000).withTimeout(15, TimeUnit.SECONDS);
        return new LetterPageIua(driver);
    }

    public SentMailPage goToSentMailPage() {
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        sentButton.click();
        new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        return new SentMailPageIua(driver);
    }

    public void checkCurrentAccount(String account){
        Assert.assertTrue(this.getCurrentAccount().equals(account));
    }
}
