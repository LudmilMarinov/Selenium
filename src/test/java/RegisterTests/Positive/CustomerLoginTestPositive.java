package RegisterTests.Positive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.time.Duration;

public class CustomerLoginTestPositive {
    static WebDriver driver;

    /**
     * Starts browser maximized
     */
    @BeforeMethod
    public static void setupBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://shop.pragmatic.bg/index.php?route=account/login");
    }

    /**
     * After test is complete quits the opened browser
     */
    @AfterMethod
    void tearDown() {
        driver.quit();
    }
    @Test
    public void loginTestWithCorrectCredentials() {
        driver.findElement(By.id("input-email")).sendKeys("L_marinov92@abv.bg");
        driver.findElement(By.id("input-password")).sendKeys("Ludmil1");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "My Account";
        assertEquals(expectedTitle, actualTitle);
    }
}
