package driverExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ChromeDriverExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("--start-maximized", "--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("http://pragmatic.bg/automation/example4.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExamples() {
        WebElement element = driver.findElement(By.id("selectLoad"));
        String value = element.getAttribute("value");
        Assert.assertEquals("Click to load the select below", value);
    }
}