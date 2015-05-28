package com.epam.pashkov;

import com.epam.pashkov.pageobject.*;
import com.epam.pashkov.pageobject.gmail.com.LoginPageGmail;
import com.epam.pashkov.pageobject.i.ua.LoginPageIua;
import com.epam.pashkov.pageobject.yandex.ru.LoginPageYandex;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class MailTest {
    WebDriver driver;

    @BeforeTest
    public void preconditions(){
        driver = WebBrowserFactory.getWebDriver(WebDriverEnum.CHROME);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void postconditions(){
        driver.quit();
    }

    @Test
    public void verifyIua() {
        //Step 1
        LoginPage loginPage = new LoginPageIua(driver);
        StartMailPage startMailPage = loginPage.login("pashyaro@i.ua", "12345qwerty");
        //Step 2
        startMailPage.checkCurrentAccount("pashyaro@i.ua");
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
        //Step 1
        LoginPage loginPage = new LoginPageYandex(driver);
        StartMailPage startMailPage = loginPage.login("pashyaro@yandex.ru", "12345qwerty");
        //Step 2
        startMailPage.checkCurrentAccount("pashyaro@yandex.ru");
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
        //Step 1
        LoginPage loginPage = new LoginPageGmail(driver,true);
        StartMailPage startMailPage = loginPage.login("pashyaro@gmail.com", "12345qwertysingle");
        //Step 2
        startMailPage.checkCurrentAccount("pashyaro@gmail.com");
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
