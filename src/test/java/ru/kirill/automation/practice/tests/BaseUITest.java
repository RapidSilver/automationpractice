package ru.kirill.automation.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.kirill.automation.practice.pom.AccountPage;
import ru.kirill.automation.practice.pom.AuthPage;
import ru.kirill.automation.practice.pom.HomePage;
import ru.kirill.automation.practice.pom.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class BaseUITest {
    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;
    AuthPage authPage;
    RegistrationPage registrationPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 5);
        this.homePage = new HomePage(driver, wait);
        this.authPage = new AuthPage(driver, wait);
        this.registrationPage = new RegistrationPage(driver, wait);
        this.accountPage = new AccountPage(driver, wait);
    }

    @AfterMethod
    public void shutdown() {
        driver.quit();
    }
}
