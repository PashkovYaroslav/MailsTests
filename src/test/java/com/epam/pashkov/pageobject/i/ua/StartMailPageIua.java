package com.epam.pashkov.pageobject.i.ua;

import com.epam.pashkov.helper.WaiterHelper;
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
    public static final String PRE_LOGOUT_BUTTON = "//li[@class='ho_menu_item']/span[@class='icon-ho ho_settings']";
    public static final String LOGOUT_BUTTON_LOCATOR = "//li[@class='ho_popup_menu_item']/a[text()='Выйти']";

    @FindBy(xpath = DRAFT_BUTTON)
    private WebElement draftButton;

    @FindBy(xpath = SENT_BUTTON)
    private WebElement sentButton;

    @FindBy(xpath = CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = WRITE_LETTER_BUTTON)
    private WebElement writeLetterButton;

    @FindBy(xpath = PRE_LOGOUT_BUTTON)
    private WebElement preLogoutButton;

    @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButtonLocator;

    public StartMailPageIua(WebDriver driver) {
        super(driver);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPageIua goToDraftPage() {
        wait.delay(3000);
        draftButton.click();
        return new DraftMailPageIua(driver);
    }

    public LetterPageIua openNewLetterPage() {
        writeLetterButton.click();
        return new LetterPageIua(driver);
    }

    public SentMailPageIua goToSentMailPage() {
        sentButton.click();
        return new SentMailPageIua(driver);
    }

    public void logout() {
        preLogoutButton.click();
        wait.waitVisibilityOf(driver, logoutButtonLocator);
        logoutButtonLocator.click();
    }
}
