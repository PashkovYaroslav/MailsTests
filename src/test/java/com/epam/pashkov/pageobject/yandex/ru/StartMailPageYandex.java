package com.epam.pashkov.pageobject.yandex.ru;

import com.epam.pashkov.helper.WaiterHelper;
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
public class StartMailPageYandex extends AbstractPage {

    public static final String DRAFT_BUTTON = "//div[@class='b-folders__i']/div[5]/span[2]/a";
    public static final String SENT_BUTTON = "//div[@class='b-folders__i']/div[2]/span[2]/a";
    public static final String CURRENT_ACCOUNT_TEXT = "(//*[contains(@id,'nb')])[1]/span[1]";
    public static final String WRITE_LETTER_BUTTON = "//div[contains(@class,'b-toolbar__block_chevron')]//img[contains(@class,'b-ico_compose')]";
    public static final String PRE_LOGOUT_BUTTON = "//span[@class='header-user-name js-header-user-name']";
    public static final String LOGOUT_BUTTON_LOCATOR = "//a[text()='Выход']";
    public static final String DRAFT_PAGE_TITLE = "Черновики";
    public static final String INBOX_PAGE_TITLE = "Входящие";
    public static final String SENT_PAGE_TITLE = "Отправленные";

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

    public StartMailPageYandex(WebDriver driver) {
        super(driver);
    }

    public String getCurrentAccount(){
        return currentAccountText.getText();
    }

    public DraftMailPageYandex goToDraftPage() {
        draftButton.click();
        wait.waitTitleContains(driver, DRAFT_PAGE_TITLE);
        return new DraftMailPageYandex(driver);
    }

    public LetterPageYandex openNewLetterPage() {
        wait.waitTitleContains(driver, INBOX_PAGE_TITLE);
        writeLetterButton.click();
        return new LetterPageYandex(driver);
    }

    public SentMailPageYandex goToSentMailPage() {
        wait.waitTitleContains(driver,INBOX_PAGE_TITLE);
        sentButton.click();
        wait.waitTitleContains(driver, SENT_PAGE_TITLE);
        return new SentMailPageYandex(driver);
    }

    public void logout() {
        preLogoutButton.click();
        wait.waitVisibilityOf(driver, logoutButtonLocator);
        logoutButtonLocator.click();
    }
}
