package elementExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class RadioButtonTest {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
    }

    @Test
    public void testRadioButton() {
        //Get the Radio Button as WebElement using it's value attribute
        WebElement petrol = driver.findElement(By.xpath("//input[@value='Petrol']"));

        //Check if its already selected? otherwise select the Radio Button
        //by calling click() method
        if (!petrol.isSelected()) {
            petrol.click();
        }

        //Verify Radio Button is selected
        assertTrue(petrol.isSelected());

        //We can also get all the Radio buttons from a Radio Group in a list
        //using findElements() method along with Radio Group identifier
        List<WebElement> fuel_type = driver.findElements(By.name("fuel_type"));
        for (WebElement type : fuel_type) {
            //Search for Diesel Radio Button in the Radio Group and select it
            if (type.getAttribute("value").equals("Diesel")) {
                if (!type.isSelected())
                    type.click();

                assertTrue(type.isSelected());
                break;
            }
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}