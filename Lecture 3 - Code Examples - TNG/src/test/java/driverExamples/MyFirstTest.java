package driverExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyFirstTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:\\webdrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://pragmatic.bg/automation/example4.html");
    }

    @Test
    public void myFirstTest() {
        WebElement nextBidElement = driver.findElement(By.id("nextBid"));
        nextBidElement.sendKeys("1500120131343365");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

}
