package seleniumapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DragDropTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testDragDrop() {
        driver.get("http://pragmatic.bg/automation/lecture13/DragDropDemo.html");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions bla = new Actions(driver);

        bla.dragAndDrop(source, target).perform();

        assertEquals(target.getText(), "Dropped!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}