package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenerator;

public class CreateAccountTest extends UIBaseClass {
    /*
    CreateAccountTest
    Story 4: Navigate to Create Account page and Create new Account
    Validate New Account Created.
     */
    @Test
    public void createNewAccountTestPositive() {
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);

        String expectedEmail = DataGenerator.generateRandomEmail("Mohammad");

        signUpPage.fillUpCreateAccountForm("Mohammad", expectedEmail, "Password@123");

        String actualEmail = getElementText(accountProfilePage.accountEmailInfo);

        Assert.assertEquals(actualEmail, expectedEmail,
                "Profile Page should have same email as Created");
    }

}
