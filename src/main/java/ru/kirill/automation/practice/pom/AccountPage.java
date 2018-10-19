package ru.kirill.automation.practice.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BaseActions {
    private static final By ACCOUNT_PAGE_BODY = By.cssSelector("body#my-account");

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isItStartAccountPage() {
        return isElementPresent(ACCOUNT_PAGE_BODY);
    }
}
