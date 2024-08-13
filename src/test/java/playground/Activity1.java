package playground;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Activity1 {

    @Test
    public void navigateToFacebook(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        String Title=driver.getTitle();
        System.out.println("Facebook title" + Title);
        driver.quit();
    }
}
