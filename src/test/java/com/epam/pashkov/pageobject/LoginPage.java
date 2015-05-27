package com.epam.pashkov.pageobject;

/**
 * Created by Yaroslav on 24.05.2015.
 */
public interface LoginPage {
    public StartMailPage login(String userName, String password);
    public LoginPage logout();
}
