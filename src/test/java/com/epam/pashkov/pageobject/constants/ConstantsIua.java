package com.epam.pashkov.pageobject.constants;

/**
 * Created by Yaroslav_Pashkov on 5/25/2015.
 */
public class ConstantsIua {
    // Draft Page
    public static final String LATEST_MESSAGE = ".//*[@id='mesgList']//a/span[2]";

    // Letter Page
    public static final String TITLE_INPUT = "//input[@name='subject']";
    public static final String RECIPIENT_INPUT = ".//*[@id='to']";
    public static final String TEXT_INPUT = ".//*[@id='text']";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON = "//p[@class='send_container']/input[@name='save_in_drafts']";
    public static final String SEND_LETTER_BUTTON = "(//input[@name='send'])[1]";

    // Login Page
    public static final String USER_NAME_LOCATOR = "//*[@name='login']";
    public static final String PASSWORD_LOCATOR = "//*[@name='pass']";
    public static final String LOGIN_BUTTON_LOCATOR = "//form/p/input";
    public static final String LOGOUT_BUTTON_LOCATOR = "//ul[@class='user_menu']/li[@class='right']/a";

    // Sent Mail Page
    public static final String LATEST_SENT_MAIL = ".//*[@id='mesgList']//a/span[2]";

    // Start Mail Page
    public static final String DRAFT_BUTTON = "//ul[@class='list_underlined']/li[3]";
    public static final String SENT_BUTTON = "//ul[@class='list_underlined']/li[2]";
    public static final String CURRENT_ACCOUNT_TEXT = "//span[@class='sn_menu_title']";
    public static final String WRITE_LETTER_BUTTON = "//p[@class='make_message']";
}
