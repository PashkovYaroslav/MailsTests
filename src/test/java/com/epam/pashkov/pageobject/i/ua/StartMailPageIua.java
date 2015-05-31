package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class StartMailPageIua extends AbstractPage {

    public static final String DRAFT_BUTTON = "//ul[@class='list_underlined']/li[3]/a";
    public static final String SENT_BUTTON = "//ul[@class='list_underlined']/li[2]/a";
    public static final String CURRENT_ACCOUNT_TEXT = "//span[@class='sn_menu_title']";
    public static final String WRITE_LETTER_BUTTON = "//p[@class='make_message']/a";

    @FindBy(xpath = DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    public StartMailPageIua(WebDriver driver) {
        super(driver);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPageIua goToDraftPage() {
        new WebDriverWait(driver, 5, 500);
        draftButton.click();
        return new DraftMailPageIua(driver);
    }

    public LetterPageIua openNewLetterPage() {
        //new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        writeLetterButton.click();
        //new WebDriverWait(driver, 15, 5000).withTimeout(15, TimeUnit.SECONDS);
        return new LetterPageIua(driver);
    }

    public SentMailPageIua goToSentMailPage() {
        //new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        sentButton.click();
        //new WebDriverWait(driver, 5, 5000).withTimeout(5, TimeUnit.SECONDS);
        return new SentMailPageIua(driver);
    }

    public void checkCurrentAccount(String account){
        Assert.assertTrue(this.getCurrentAccount().equals(account));
    }
}
