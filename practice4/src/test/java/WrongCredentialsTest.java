import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WrongCredentialsTest {

    public WebDriver driver;

    /**
     * Opens Chrome driver, navigates to a page, sets the window to maximized, and puts implicit wait time of 10 Seconds
     */
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg/admin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Tries to login with wrong credentials, and asserts that a error message is displayed.
     */
    @Test
    public void wrongCredentialsTest() {
        driver.findElement(By.id("input-username")).sendKeys("admin");
        driver.findElement(By.id("input-password")).sendKeys("parola123");
        driver.findElement(By.xpath("//button[contains(text(),' Login')]")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'No match')]"));
        assertEquals(errorMessage.getText(), "No match for Username and/or Password.\n" +
                "×");
    }

    /**
     * Closes the driver.
     */
    @AfterMethod
    public void driverTermination() {
        driver.quit();
    }
}
