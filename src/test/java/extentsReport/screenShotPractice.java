package extentsReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class screenShotPractice {


    static WebDriver driver;
    // to store the screenshot in your project level
    public static String captureScreenshot1(String fileName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile =  new File("./ScreenShots"+ fileName);
        System.out.println("destFile data =" + destFile);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("ScreenShot saved Successfully");
        return destFile.getAbsolutePath();
    }
    // to store the screenshot in a String
    public static String captureScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("ScreenShot saved Successfully");
        return base64Code;
    }


    public static void main(String[] args) throws IOException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");


        ExtentReports extentReports = new ExtentReports();
        // class to generete open seoruce

        String path1 =  System.getProperty("testCase.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testCaseResult.html");
        extentReports.attachReporter(sparkReporter);

        // Attached screenshot in test level
        String path = captureScreenshot1("google.jpg");
        extentReports.createTest("Test case 1").addScreenCaptureFromPath(path);

        extentReports.createTest("Test case 2").addScreenCaptureFromBase64String(captureScreenshot());

        // Attached screenshot in log level
        extentReports.createTest("Test case 3")
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        extentReports.createTest("Test case 4").fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());


        extentReports.createTest("TEST 5" )
                .assignAuthor("hamid")
                .assignCategory("smoke")
                .assignDevice("chome")
                .fail("this is falied test");

        extentReports.createTest("TEST 6" )
                .assignAuthor("Rahim")
                .assignCategory("smoke")
                .assignDevice("chome")
                .fail("this is falied test");
        extentReports.createTest("TEST 7" )
                .assignAuthor("Rahim")
                .assignCategory("smoke")
                .assignDevice("chome")
                .fail("this is falied test");
        extentReports.createTest("TEST 8" )
                .assignAuthor("hamid")
                .assignCategory("smoke")
                .assignDevice("chome")
                .fail("this is falied test");

        extentReports.createTest("TEST 9" )
                .assignAuthor("hamid")
                .assignCategory("smoke")
                .assignDevice("chome")
                .fail("this is falied test");
        extentReports.createTest("TEST 10" )
                .assignAuthor("Rahim", "Ghazal", "Sh")
                .assignAuthor("hamid")
                .assignCategory("smoke")
                .assignDevice("chome")
                .fail("this is falied test");

        driver.quit();

        extentReports.flush();
        Desktop.getDesktop().browse(new File("testCaseResult.html").toURI());

    }

}

