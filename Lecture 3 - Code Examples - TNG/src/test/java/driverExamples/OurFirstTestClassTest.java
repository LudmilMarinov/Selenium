package driverExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OurFirstTestClassTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/example4.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    public void testExamples() {
        WebElement element = driver.findElement(By.id("nextBid"));
        element.sendKeys("100");
    }
}
