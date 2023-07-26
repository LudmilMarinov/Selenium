package driverExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class EdgeDriverExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "D:\\webdrivers\\msedgedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\86.0.622.43\\msedge.exe");
//        EdgeOptions edgeOptions = new EdgeOptions().merge(options);
//        driver = new EdgeDriver(edgeOptions);
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://abv.bg");
    }

    @Test
    public void testExamples() {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("pragmabg");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("parola");
        driver.findElement(By.id("loginBut")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
