package com.epam.pashkov.pageobject.constants;

/**
 * Created by Yaroslav_Pashkov on 5/26/2015.
 */
public class ConstantsGmail {
    // Draft Page
    public static final String LATEST_MESSAGE = "(//td[@tabindex='-1']/div[@role='link']//span[1])[4]";
    public static final String INBOX_BUTTON = "//a[contains(text(),'Входящие')]";

    // Letter Page
    public static final String TITLE_INPUT = "//input[@name='subjectbox']";
    public static final String RECIPIENT_INPUT = "//textarea[@aria-label='Кому']";
    public static final String RECIPIENT_LIST = "//form//span[@email]/div[1]";
    public static final String TEXT_INPUT = "//div[@aria-label='Тело письма']";
    public static final String SAVE_LETTER_TO_DRAFT_BUTTON = "//img[@alt='Закрыть']";
    public static final String SEND_LETTER_BUTTON = "//div[text()='Отправить']";

    // Login Page
    public static final String USER_NAME_LOCATOR = ".//input[@id='Email']";
    public static final String NEXT_BUTTON = ".//input[@id='next']";
    public static final String PASSWORD_LOCATOR = ".//*[@id='Passwd']";
    public static final String LOGIN_BUTTON_LOCATOR = ".//*[@id='signIn']";
    public static final String LOGOUT_BUTTON_LOCATOR = "//a[contains(text(),'Выйти')]";

    // Sent Mail Page
    public static final String LATEST_SENT_MAIL = "(//tr[@aria-labelledby]/td[4]//span[@name])[7]";

    // Start Mail Page
    public static final String DRAFT_BUTTON = "//a[contains(text(),'Черновики')]";
    public static final String SENT_BUTTON = "//a[contains(text(),'Отправленные')]";
    public static final String CURRENT_ACCOUNT_TEXT = ".//*[@id='gb']//a[contains(@class,'gb_ga') and contains(@title,'Аккаунт')]";
    public static final String WRITE_LETTER_BUTTON = "//div[text()='НАПИСАТЬ']";

    // Old UI letter page
    public static final String RECIPIENT_UI = "//div[@tabindex='1']//span[@email]";
    public static final String SUBJECT_UI = "//input[@name='subjectbox']";
}
