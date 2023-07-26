package elementExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementTests {

    static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/lecture13/DoubleClickDemo.html");
    }

    @Test
    public void testElementText() {
        //Get the message Element
        WebElement message = driver.findElement(By.id("message"));

        //Get the message elements text
        String actualMessageText = message.getText();
        String expectedMessageText = "Click on me and my color will change";

        Assert.assertEquals(actualMessageText,
                expectedMessageText,
                "this will appear if expected and actual are not the same");
        Assert.assertTrue(actualMessageText.contains("color"), "nqma q be, bug");

        //Verify message element's text displays "Click on me and my color will change"
        //Assert.assertEquals("Click on me and my color will change", messageText);

        //Get the area Element
        WebElement area = driver.findElement(By.id("area"));

        //Verify area element's text displays "Div's Text\nSpan's Text"
        Assert.assertEquals(area.getText(), "Div's Text\nSpan's Text", "bug beee");
    }


    @Test
    public void testElementAttribute() {
        WebElement message = driver.findElement(By.id("message"));
        String observedAlignment = message.getAttribute("align");
        Assert.assertEquals(observedAlignment, "justify");
    }

    @Test
    public void testElementStyle() {
        WebElement message = driver.findElement(By.id("message"));
        String width = message.getCssValue("");
        Assert.assertEquals(width, "150px");
    }

    @AfterMethod
    public static void tearDown() {
        driver.close();
    }
}