package com.epam.pashkov.pageobject;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public interface StartMailPage {
    public String getCurrentAccount();
    public LetterPage openNewLetterPage();
    public DraftMailPage goToDraftPage();
    public SentMailPage goToSentMailPage();
    public void checkCurrentAccount(String account);
}
