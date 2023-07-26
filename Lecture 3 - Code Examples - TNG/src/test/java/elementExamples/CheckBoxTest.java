package elementExamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
    }

    @Test
    public void testCheckBox() {
        //Get the Checkbox as WebElement using it's value attribute
        WebElement airbags = driver.findElement(By.xpath("//input[@value='Airbags']"));

        //Check if its already selected? otherwise select the Checkbox
        //by calling click() method
        if (!airbags.isSelected()) {
            airbags.click();
        }

        //Verify Checkbox is Selected
        assertTrue(airbags.isSelected());

        //Check Checkbox if selected? If yes, deselect it
        //by calling click() method
        if (airbags.isSelected()) {
            airbags.click();
        }

        //Verify Checkbox is Deselected
        assertFalse(airbags.isSelected());
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}