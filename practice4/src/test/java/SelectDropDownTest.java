import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class SelectDropDownTest {

    public WebDriver driver;

    /**
     * Opens Chrome driver, navigates to a page, sets the window to maximized, and puts implicit wait time of 10 Seconds
     */
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg/admin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    /**
     * Compares the dropdown menus on sales/order page.
     */
    @Test
    public void selectTest(){
        driver.get("https://shop.pragmatic.bg/admin/index.php?route=sale/order&user_token=crsrCm6tO9pFHuN7VOdCJpa806quyqOF");
        driver.findElement(By.id("input-username")).sendKeys("admin");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.xpath("//button[contains(text(),' Login')]")).click();

        WebElement dropDownElement = driver.findElement(By.id("input-order-status"));
        Select dropDown = new Select (dropDownElement);
        assertFalse(dropDown.isMultiple());
        assertEquals(dropDown.getOptions().size(), 16);
        List<String> expectedResult = Arrays.asList("", "Missing Orders", "Canceled", "Canceled Reversal", "Chargeback", "Complete", "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided");
        List<String> actualResult =new ArrayList<String>();
        List<WebElement> allOptions =dropDown.getOptions();

        for (WebElement option: allOptions) {
            actualResult.add(option.getText());
        }
        assertEquals(actualResult.toArray(), expectedResult.toArray());
    }
    /**
     * Closes the driver.
     */
    @AfterMethod
    public void driverTermination () {
        driver.quit();
    }
}
