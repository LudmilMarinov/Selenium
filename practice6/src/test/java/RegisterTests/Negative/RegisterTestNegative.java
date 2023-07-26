package RegisterTests.Negative;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.time.Duration;


public class RegisterTestNegative {
    public static WebDriver driver;

    /**
     * Starts browser maximized
     */
    @BeforeMethod
    public static void setupBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://shop.pragmatic.bg/");

    }

//    /**
//     * After test is complete quits the opened browser
//     */
//    @AfterMethod
//    void tearDown() {
//        driver.quit();
//    }
    @Test
    public void registerTest(){

        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Ludmil");
        driver.findElement(By.id("input-lastname")).sendKeys("Marinov");
//        driver.findElement(By.id("input-email")).sendKeys("L_marinov92@abv.bg");
        driver.findElement(By.id("input-telephone")).sendKeys("+359885601380");
        driver.findElement(By.id("input-password")).sendKeys("Ludmil1");
        driver.findElement(By.id("input-confirm")).sendKeys("Ludmil1");
        WebElement radioButtonElement = driver.findElement(By.xpath("//div[@class='form-group']//following-sibling::input[@value='1']"));
        if (!radioButtonElement.isSelected()) {
            radioButtonElement.click();
        }
        WebElement checkBoxElement = driver.findElement(By.xpath("//div[@class='buttons']//input[@type='checkbox']"));
        if (!checkBoxElement.isSelected()) {
            checkBoxElement.click();
        }
        driver.findElement(By.xpath("//div[@class='buttons']//input[@type='submit']")).click();
        String actualErrorMessageForMissingEmail = driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).getText();

        assertEquals(actualErrorMessageForMissingEmail, "E-Mail Address does not appear to be valid!");
    }
}
