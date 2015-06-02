package com.epam.pashkov.pageobject;

import com.epam.pashkov.helper.WaiterHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yaroslav on 31.05.2015.
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected WaiterHelper wait = new WaiterHelper();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
