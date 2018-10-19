package ru.kirill.automation.practice.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.kirill.automation.practice.pom.RegistrationPage;

public class NegativeRegistrationSpaceTest extends BaseUITest {
    @DataProvider(name = "regData")
    public Object[][] clickDealsData() {
        return new Object[][]{
                {RegistrationPage.Gender.MALE, "     ", "     ", "testmale@5710.com", "     ", "11", "5", "1980", true, true, "     ", "     ", "     ", "     ", "34", "     ", "     ", "     ", "     "},
                {RegistrationPage.Gender.MALE, "     ", "     ", "testmale@5711.com", "     ", "11", "5", "1980", true, true, "     ", "     ", "     ", "     ", "34", "12345", "     ", "     ", "     "},
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
        Assert.assertTrue(registrationPage.isAlertPresent());
    }
}
