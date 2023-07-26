import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {
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
     * Tests the login page with correct credentials, and asserts that it logs in, then logs out.
     */
    @Test
    public void backendTest() {
        driver.findElement(By.id("input-username")).sendKeys("admin");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.xpath("//button[contains(text(),' Login')]")).click();

        WebElement profileName = driver.findElement(By.xpath("//a[contains(text(),'Milen')]"));
        assert profileName.getText().equals("Milen Strahinski");

        driver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();
    }


    /**
     * Closes the driver.
     */
    @AfterMethod
    public void driverTermination() {
        driver.quit();
    }

}
