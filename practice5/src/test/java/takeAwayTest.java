import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class takeAwayTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.takeaway.com/bg");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void takeAwayTest (){
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        WebElement searchBoxInput = driver.findElement(By.xpath("//div[@class='_3xqDe']//following-sibling::label"));
        searchBoxInput.sendKeys(Keys.DELETE, "ulitsa Trudolyubie");
//        WebElement resultSearchBox = driver.findElement(By.xpath("//*[@id=\"suggestion-list-item_22\"]"));
//        resultSearchBox.click();



    }

}
