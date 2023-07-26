package simpleBrowserExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleBrowserExamples {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//
//        This example is using OperaOptions and setBinary file due to error in case the binary is not set by
//        default for some reason

//        WebDriverManager.operadriver().setup();
//        OperaOptions options = new OperaOptions();
//        options.setBinary("C:\\Program Files\\Opera\\71.0.3770.271\\opera.exe");
//        driver = new OperaDriver(options);
//
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        !!! IMPORTANT NOTE: In case you are getting binary not found error - check how to set the binary presented in the EdgeDriverExample !!!
//
//        System.setProperty("webdriver.ie.driver", "D:\\webdrivers\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/");
    }

    @Test
    public void testOne() throws InterruptedException {
        WebElement usernameInput = driver.findElement(By.cssSelector("#search input"));
        usernameInput.sendKeys("pragmabg");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
