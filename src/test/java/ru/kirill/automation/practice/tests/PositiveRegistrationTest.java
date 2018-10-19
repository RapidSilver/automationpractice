package ru.kirill.automation.practice.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.kirill.automation.practice.pom.RegistrationPage;

public class PositiveRegistrationTest extends BaseUITest {
    @DataProvider(name = "regData")
    public Object[][] clickDealsData() {
        return new Object[][]{
                {RegistrationPage.Gender.MALE, "name", "name", "testmale@5712.com", "12345", "11","5","1980", true, true, "company", "qwerty, 123, zxcvb", "asdf, 56, trewq", "gdeto-tam", "34", "12345", "qwertyuiopasassaasasas", "1234567890", "0123456789"},
                {RegistrationPage.Gender.FEMALE, "name", "name", "testmale@5713.com", "12345", "11","5","1980", true, true, "company", "qwerty, 123, zxcvb", "asdf, 56, trewq", "gdeto-tam", "34", "12345", "qwertyuiopasassaasasas", "1234567890", "0123456789"},
                {RegistrationPage.Gender.MALE, "name", "name", "testmale@5714.com", "12345", "11","5","1980", true, true, "company", "qwerty, 123, zxcvb", "asdf, 56, trewq", "gdeto-tam", "34", "12345", "qwertyuiopasassaasasas", "1234567890", "0123456789"}
        };
    }

    @Test(dataProvider = "regData")
    public void tryToRegister(RegistrationPage.Gender gender,
                              String firstName,
                              String lastName,
                              String email,
                              String password,
                              String birthDay,
                              String birthMonth,
                              String birthYear,
                              Boolean newsletter,
                              Boolean offers,
                              String company,
                              String addressLine1,
                              String addressLine2,
                              String city,
                              String state,
                              String postalCode,
                              String information,
                              String phone,
                              String mobilePhone) {

        homePage.home();
        homePage.goToAuthPage();
        authPage.fillRegistrationEmailAndConfirm(email);
        registrationPage.typePersonalInfo(gender, firstName, lastName, email, password, birthDay, birthMonth, birthYear, newsletter, offers, company, addressLine1, addressLine2, city, state, postalCode, information, phone, mobilePhone);
        registrationPage.submitRegistration();
        Assert.assertTrue(accountPage.isItStartAccountPage());
        homePage.home();
        homePage.logout();
        homePage.goToAuthPage();
        authPage.fillSignInFormAndConfirm(email, password);
        Assert.assertFalse(authPage.isAlertPresent());
    }
}
