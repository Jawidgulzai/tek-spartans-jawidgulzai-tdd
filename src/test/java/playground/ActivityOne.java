package playground;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ActivityOne {

    /*
    Write a test that navigates to Facebook.com
    and print Title
     */
    private WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void testFacebookTitle() {
        String applicationTitle = driver.getTitle();
        Assert.assertEquals(applicationTitle, "xFacebook - log in or sign up");
    }

    @AfterMethod
    public void cleanupTest() {
        driver.quit();
    }
}
