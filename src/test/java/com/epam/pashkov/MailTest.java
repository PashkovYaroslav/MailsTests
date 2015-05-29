package com.epam.pashkov;

import com.epam.pashkov.pageobject.*;
import com.epam.pashkov.pageobject.gmail.com.LoginPageGmail;
import com.epam.pashkov.pageobject.i.ua.LoginPageIua;
import com.epam.pashkov.pageobject.yandex.ru.LoginPageYandex;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class MailTest {
    WebDriver driver;
    ResourceBundle credentials;

    @BeforeTest
    public void preconditions(){
        driver = WebBrowserFactory.getWebDriver(WebDriverEnum.CHROME);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        credentials = ResourceBundle.getBundle("credentials");
    }

    @AfterTest
    public void postconditions(){
        driver.quit();
    }

    @Test
    public void verifyIua() {
        String login = credentials.getString("i.ua.login");
        String password = credentials.getString("i.ua.password");
        //Step 1
        LoginPage loginPage = new LoginPageIua(driver);
        StartMailPage startMailPage = loginPage.login(login, password);
        //Step 2
        startMailPage.checkCurrentAccount(login);
        // Step 3
        LetterPage letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter("Test3", "generalyaro@gmail.com", "Text of message");
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPage draftMailPage = startMailPage.goToDraftPage();
        draftMailPage.checkContainsOfMessage(true);
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        letterPage.checkLetter("generalyaro@gmail.com", "Test3", "Text of message");
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        startMailPage.goToDraftPage().checkContainsOfMessage(false);
        // Step 10
        SentMailPage sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        sentMailPage.checkContainsOfMessage("generalyaro@gmail.com");
        // Step 11
        loginPage = sentMailPage.goToLoginPage();
        loginPage.logout();
    }

    @Test
    public void verifyYandex() {
        String login = credentials.getString("yandex.ru.login");
        String password = credentials.getString("yandex.ru.password");
        //Step 1
        LoginPage loginPage = new LoginPageYandex(driver);
        StartMailPage startMailPage = loginPage.login(login, password);
        //Step 2
        startMailPage.checkCurrentAccount(login);
        // Step 3
        LetterPage letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter("TestYandex", "generalyaro@gmail.com", "Text of message");
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPage draftMailPage = startMailPage.goToDraftPage();
        draftMailPage.checkContainsOfMessage(true);
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        letterPage.checkLetter("\"Ярослав Пашков\" <generalyaro@gmail.com>", "TestYandex", "Text of message");
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        startMailPage.goToDraftPage().checkContainsOfMessage(false);
        // Step 10
        SentMailPage sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        sentMailPage.checkContainsOfMessage("Ярослав Пашков");
        // Step 11
        loginPage = sentMailPage.goToLoginPage();
        loginPage.logout();
    }

    @Test
    public void verifyGoogle() {
        String login = credentials.getString("gmail.com.login");
        String password = credentials.getString("gmail.com.password");
        //Step 1
        LoginPage loginPage = new LoginPageGmail(driver,true);
        StartMailPage startMailPage = loginPage.login(login, password);
        //Step 2
        startMailPage.checkCurrentAccount(login);
        // Step 3
        LetterPage letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter("TestGmail", "generalyaro@gmail.com", "Text of message");
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPage draftMailPage = startMailPage.goToDraftPage();
        draftMailPage.checkContainsOfMessage(true);
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        letterPage.checkLetter("Ярослав Пашков", "TestGmail", "Text of message");
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        startMailPage.goToDraftPage().checkContainsOfMessage(false);
        // Step 10
        SentMailPage sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        sentMailPage.checkContainsOfMessage("Ярослав Пашков");
        // Step 11
        loginPage = sentMailPage.goToLoginPage();
        loginPage.logout();
    }
}
