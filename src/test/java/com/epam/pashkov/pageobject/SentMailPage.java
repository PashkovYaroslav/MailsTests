package com.epam.pashkov.pageobject;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public interface SentMailPage {
    public String getLatestSentMail();
    public LoginPage goToLoginPage();
    public void checkContainsOfMessage(String recipient);
}
