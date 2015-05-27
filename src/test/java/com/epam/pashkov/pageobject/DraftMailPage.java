package com.epam.pashkov.pageobject;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public interface DraftMailPage {
    public boolean getLatestLetter();
    public LetterPage openLatestLetter();
    public StartMailPage openStartMailPage();
    public void checkContainsOfMessage(boolean expected);
}
