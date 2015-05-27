package com.epam.pashkov.pageobject;


/**
 * Created by Yaroslav on 24.05.2015.
 */
public interface LetterPage {
    public void createLetter(String title, String recipient, String text);
    public StartMailPage saveLetterToDraft();
    public StartMailPage sendLetter();
    public String getTitle();
    public String getRecipient();
    public String getLetterText();
    public void checkLetter(String recipient, String subject, String text);
}
