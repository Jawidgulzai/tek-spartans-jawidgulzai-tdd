package extentsReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class CustomizeTemplate {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        WebDriver driver;
        // Engine
        ExtentReports extentReports = new ExtentReports();
        String path1 = "D:\\SpartansWorkSpace2\\tek-spartans-jawidgulzai-tdd\\target\\Report123.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path1);
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Report name");
        sparkReporter.config().setDocumentTitle("TEKSCHOOL title Report");
        sparkReporter.config().setTimeStampFormat("yyyy-mm-dd hh:mm:ss");
        sparkReporter.config().setCss(".badge-primary{background-color:#5f0422}");
        sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
        sparkReporter.loadXMLConfig(new File("D:\\SpartansWorkSpace2\\tek-spartans-jawidgulzai-tdd\\src\\test\\resources\\reportxml.xml"));
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

        driver.get("https://www.yahoo.com/");

        System.getProperties().list(System.out);
        extentReports.setSystemInfo("JavaVersion", System.getProperty("java.version"));
        extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Browser", capabilities.getBrowserName());
        extentReports.setSystemInfo("BrowserVersion", capabilities.getBrowserVersion());

        driver.quit();
        extentReports.flush();
        Desktop.getDesktop().browse(new File(path1).toURI());

    }
}