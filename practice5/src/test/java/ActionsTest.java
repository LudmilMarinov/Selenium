import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
    }

    @Test
    public void actionsTest () throws InterruptedException {
        WebElement colorSelect = driver.findElement(By.name("color"));
        Actions select = new Actions(driver);
        assertFalse(colorSelect.isSelected());
        WebElement silverWebElement = colorSelect.findElement(By.xpath("//*[contains(text(),'Silver')]"));
        WebElement redWebElement = colorSelect.findElement(By.xpath("//*[contains(text(),'Red')]"));
        select.keyDown(Keys.CONTROL).click(silverWebElement).click(redWebElement).perform();
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
