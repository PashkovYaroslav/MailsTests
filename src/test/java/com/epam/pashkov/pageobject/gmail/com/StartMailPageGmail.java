package com.epam.pashkov.pageobject.gmail.com;

import com.epam.pashkov.pageobject.DraftMailPage;
import com.epam.pashkov.pageobject.LetterPage;
import com.epam.pashkov.pageobject.SentMailPage;
import com.epam.pashkov.pageobject.StartMailPage;
import com.epam.pashkov.pageobject.constants.ConstantsGmail;
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
public class StartMailPageGmail implements StartMailPage {
    private WebDriver driver;

    @FindBy(xpath = ConstantsGmail.DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = ConstantsGmail.SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = ConstantsGmail.CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = ConstantsGmail.WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    public StartMailPageGmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPage goToDraftPage() {
        draftButton.click();
        //new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Черновики"));
        return new DraftMailPageGmail(driver);
    }

    public LetterPage openNewLetterPage() {
        writeLetterButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LetterPageGmail(driver);
    }

    public SentMailPage goToSentMailPage() {
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Входящие"));
        sentButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.titleContains("Отправленные"));
        return new SentMailPageGmail(driver);
    }

    public void checkCurrentAccount(String account){
        Assert.assertTrue(this.getCurrentAccount().equals(account));
    }
}
