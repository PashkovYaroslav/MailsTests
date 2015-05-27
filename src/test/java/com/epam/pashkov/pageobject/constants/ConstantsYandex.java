package com.epam.pashkov.pageobject.constants;

/**
 * Created by Yaroslav_Pashkov on 5/25/2015.
 */
public class ConstantsYandex {
    // Draft Page
    public static final String LATEST_MESSAGE = "//div[@class='b-messages']/div[1]//span[@class='b-messages__from__text']";
    public static final String INBOX_BUTTON = "//div[@class='b-folders__i']/div[1]/span[2]/a";

    // Letter Page
    public static final String TITLE_INPUT = "//*[@id='compose-subj']";
    public static final String RECIPIENT_INPUT = "(//div[contains(@class,'b-mail-input_yabbles')]//input[contains(@class,'b-yabble__input')])";
    public static final String TEXT_INPUT = "//*[@id='compose-send']";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON = "(//button[contains(@id,'nb')])[4]";
	  public static final String SAVE_LETTER_TO_DRAFT_BUTTON_POPUP = "//div[@class='b-popup__confirm']/button[1]";
    public static final String SEND_LETTER_BUTTON = "(//button[contains(@id,'nb')])[1]";
    public static final String SUCCESS_SEND_LETTER = "//span[contains(text(),'Письмо успешно')]";

    // Login Page
    public static final String USER_NAME_LOCATOR = ".//input[@name='login']";
    public static final String PASSWORD_LOCATOR = "//input[@name='passwd']";
    public static final String LOGIN_BUTTON_LOCATOR = "//div[@class='auth__button']/button";
	public static final String PRE_LOGOUT_BUTTON = "(//span[@class='user__name'])[1]";
    public static final String LOGOUT_BUTTON_LOCATOR = "//div[@class='userlist__links']/a";

    // Sent Mail Page
    public static final String LATEST_SENT_MAIL = "//div[contains(@class,'b-messages_threaded')]/div[1]//span[contains(@title,'generalyaro')]";

    // Start Mail Page
    public static final String DRAFT_BUTTON = "//div[@class='b-folders__i']/div[5]/span[2]/a";
    public static final String SENT_BUTTON = "//div[@class='b-folders__i']/div[2]/span[2]/a";
    public static final String CURRENT_ACCOUNT_TEXT = "(//*[contains(@id,'nb')])[1]/span[1]";
    public static final String WRITE_LETTER_BUTTON = "//div[contains(@class,'b-toolbar__block_chevron')]//img[contains(@class,'b-ico_compose')]";
}
