package com.epam.pashkov;

import com.epam.pashkov.pageobject.*;
import com.epam.pashkov.pageobject.gmail.com.*;
import com.epam.pashkov.pageobject.i.ua.*;
import com.epam.pashkov.pageobject.yandex.ru.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        LoginPageIua loginPage = new LoginPageIua(driver);
        StartMailPageIua startMailPage = loginPage.login(login, password);
        //Step 2
        Assert.assertTrue(startMailPage.getCurrentAccount().equals(login));
        // Step 3
        LetterPageIua letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter("Test3", "generalyaro@gmail.com", "Text of message");
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPageIua draftMailPage = startMailPage.goToDraftPage();
        Assert.assertTrue(draftMailPage.getLatestLetter());
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        Assert.assertTrue(letterPage.getTitle().equals("Test3"));
        Assert.assertTrue(letterPage.getLetterText().equals("Text of message"));
        Assert.assertTrue(letterPage.getRecipient().equals("generalyaro@gmail.com"));
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        Assert.assertFalse(startMailPage.goToDraftPage().getLatestLetter());
        // Step 10
        SentMailPageIua sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        Assert.assertTrue(sentMailPage.getLatestSentMail().equals("generalyaro@gmail.com"));
        // Step 11
        loginPage = sentMailPage.goToLoginPage();
        loginPage.logout();
    }

    @Test
    public void verifyYandex() {
        String login = credentials.getString("yandex.ru.login");
        String password = credentials.getString("yandex.ru.password");
        //Step 1
        LoginPageYandex loginPage = new LoginPageYandex(driver);
        StartMailPageYandex startMailPage = loginPage.login(login, password);
        //Step 2
        Assert.assertTrue(startMailPage.getCurrentAccount().equals(login));
        // Step 3
        LetterPageYandex letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter("TestYandex", "generalyaro@gmail.com", "Text of message");
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPageYandex draftMailPage = startMailPage.goToDraftPage();
        Assert.assertTrue(draftMailPage.getLatestLetter());
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        Assert.assertTrue(letterPage.getTitle().equals("TestYandex"));
        Assert.assertTrue(letterPage.getLetterText().equals("Text of message"));
        Assert.assertTrue(letterPage.getRecipient().equals("\"Ярослав Пашков\" <generalyaro@gmail.com>"));
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        Assert.assertFalse(startMailPage.goToDraftPage().getLatestLetter());
        // Step 10
        SentMailPageYandex sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        Assert.assertTrue(sentMailPage.getLatestSentMail().equals("Ярослав Пашков"));
        // Step 11
        loginPage = sentMailPage.goToLoginPage();
        loginPage.logout();
    }

    @Test
    public void verifyGoogle() {
        String login = credentials.getString("gmail.com.login");
        String password = credentials.getString("gmail.com.password");
        //Step 1
        LoginPageGmail loginPage = new LoginPageGmail(driver);
        StartMailPageGmail startMailPage = loginPage.login(login, password);
        //Step 2
        Assert.assertTrue(startMailPage.getCurrentAccount().equals(login));
        // Step 3
        LetterPageGmail letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter("TestGmail", "generalyaro@gmail.com", "Text of message");
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPageGmail draftMailPage = startMailPage.goToDraftPage();
        Assert.assertTrue(draftMailPage.getLatestLetter());
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        Assert.assertTrue(letterPage.getTitle().equals("TestGmail"));
        Assert.assertTrue(letterPage.getLetterText().equals("Text of message"));
        Assert.assertTrue(letterPage.getRecipient().equals("Ярослав Пашков"));
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        Assert.assertFalse(startMailPage.goToDraftPage().getLatestLetter());
        // Step 10
        SentMailPageGmail sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        Assert.assertTrue(sentMailPage.getLatestSentMail().equals("Ярослав Пашков"));
        // Step 11
        loginPage = sentMailPage.goToLoginPage();
        loginPage.logout();
    }
}
