package com.epam.pashkov;

import com.epam.pashkov.pageobject.gmail.com.*;
import com.epam.pashkov.pageobject.i.ua.*;
import com.epam.pashkov.pageobject.yandex.ru.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public class MailTest extends BaseTest {

    public static final String TITLE = "TitleOfTestMessage";
    public static final String RECIPIENT = "generalyaro@gmail.com";
    public static final String TEXT_OF_MESSAGE = "Text of message";
    public static final String RECIPIENT_YANDEX = "\"Ярослав Пашков\" <generalyaro@gmail.com>";
    public static final String RECIPIENT_NAME = "Ярослав Пашков";

    @Test
    public void verifyIua() {
        String login = config.getString("i.ua.login");
        String password = config.getString("i.ua.password");
        //Step 1
        LoginPageIua loginPage = new LoginPageIua(driver);
        StartMailPageIua startMailPage = loginPage.login(login, password);
        //Step 2
        Assert.assertTrue(startMailPage.getCurrentAccount().equals(login), "Verify current login.");
        // Step 3
        LetterPageIua letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter(TITLE, RECIPIENT, TEXT_OF_MESSAGE);
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPageIua draftMailPage = startMailPage.goToDraftPage();
        Assert.assertTrue(draftMailPage.hasLatestLetter(), "Verify that last letter present.");
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        Assert.assertTrue(letterPage.getTitle().equals(TITLE), "Verify that letter title is equal to "+TITLE+".");
        Assert.assertTrue(letterPage.getLetterText().equals(TEXT_OF_MESSAGE), "Verify that letter text is equal to "+TEXT_OF_MESSAGE+".");
        Assert.assertTrue(letterPage.getRecipient().equals(RECIPIENT), "Verify that letter recipient is equal to "+RECIPIENT+".");
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        Assert.assertFalse(startMailPage.goToDraftPage().hasLatestLetter(), "Verify that last letter is absent.");
        // Step 10
        SentMailPageIua sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        Assert.assertTrue(sentMailPage.getLatestSentMail().equals(RECIPIENT), "Verify that last sent letter recipient is equal "+RECIPIENT+".");
        // Step 11
        startMailPage = sentMailPage.goToStartPage();
        startMailPage.logout();
    }

    @Test
    public void verifyYandex() {
        String login = config.getString("yandex.ru.login");
        String password = config.getString("yandex.ru.password");
        //Step 1
        LoginPageYandex loginPage = new LoginPageYandex(driver);
        StartMailPageYandex startMailPage = loginPage.login(login, password);
        //Step 2
        Assert.assertTrue(startMailPage.getCurrentAccount().equals(login), "Verify current login.");
        // Step 3
        LetterPageYandex letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter(TITLE, RECIPIENT, TEXT_OF_MESSAGE);
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPageYandex draftMailPage = startMailPage.goToDraftPage();
        Assert.assertTrue(draftMailPage.hasLatestLetter(), "Verify that last letter present.");
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        Assert.assertTrue(letterPage.getTitle().equals(TITLE), "Verify that letter title is equal to "+TITLE+".");
        Assert.assertTrue(letterPage.getLetterText().equals(TEXT_OF_MESSAGE), "Verify that letter text is equal to "+TEXT_OF_MESSAGE+".");
        Assert.assertTrue(letterPage.getRecipient().equals(RECIPIENT_YANDEX), "Verify that letter recipient is equal to "+RECIPIENT_YANDEX+".");
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        Assert.assertFalse(startMailPage.goToDraftPage().hasLatestLetter(), "Verify that last letter is absent.");
        // Step 10
        SentMailPageYandex sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        Assert.assertTrue(sentMailPage.getLatestSentMail().equals(RECIPIENT_NAME), "Verify that last sent letter recipient is equal "+RECIPIENT_NAME+".");
        // Step 11
        startMailPage = sentMailPage.goToStartPage();
        startMailPage.logout();
    }

    @Test
    public void verifyGoogle() {
        String login = config.getString("gmail.com.login");
        String password = config.getString("gmail.com.password");
        //Step 1
        LoginPageGmail loginPage = new LoginPageGmail(driver);
        StartMailPageGmail startMailPage = loginPage.login(login, password);
        //Step 2
        Assert.assertTrue(startMailPage.getCurrentAccount().equals(login), "Verify current login.");
        // Step 3
        LetterPageGmail letterPage = startMailPage.openNewLetterPage();
        // Step 4
        letterPage.createLetter(TITLE, RECIPIENT, TEXT_OF_MESSAGE);
        // Step 5
        startMailPage = letterPage.saveLetterToDraft();
        // Step 6
        DraftMailPageGmail draftMailPage = startMailPage.goToDraftPage();
        Assert.assertTrue(draftMailPage.hasLatestLetter(), "Verify that last letter present.");
        // Step 7
        letterPage = draftMailPage.openLatestLetter();
        Assert.assertTrue(letterPage.getTitle().equals(TITLE), "Verify that letter title is equal to "+TITLE+".");
        Assert.assertTrue(letterPage.getLetterText().equals(TEXT_OF_MESSAGE), "Verify that letter text is equal to "+TEXT_OF_MESSAGE+".");
        Assert.assertTrue(letterPage.getRecipient().equals(RECIPIENT_NAME),  "Verify that letter recipient is equal to "+RECIPIENT_NAME+".");
        // Step 8
        startMailPage = letterPage.sendLetter();
        // Step 9
        Assert.assertFalse(startMailPage.goToDraftPage().hasLatestLetter(), "Verify that last letter is absent.");
        // Step 10
        SentMailPageGmail sentMailPage = draftMailPage.openStartMailPage().goToSentMailPage();
        Assert.assertTrue(sentMailPage.getLatestSentMail().equals(RECIPIENT_NAME), "Verify that last sent letter recipient is equal "+RECIPIENT_NAME+".");
        // Step 11
        startMailPage = sentMailPage.goToStartPage();
        startMailPage.logout();
    }
}
