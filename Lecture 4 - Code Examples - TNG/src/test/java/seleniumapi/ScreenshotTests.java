package seleniumapi;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenshotTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test //open class ScreenshotTests
    public void testTakesScreenshot() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File scrFile = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Temp\\main_page.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testElementScreenshot() {
        WebElement pmoabsdiv = driver.findElement(By.id("hplogo"));
        try {
            FileUtils.copyFile(captureElementBitmap(pmoabsdiv), new File("C:\\Temp\\div.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teadDown() {
        driver.quit();
    }

    //helper method for catching a PNG file screenshot of a specific element, because it's not supported by default by Selenium
    public static File captureElementBitmap(WebElement element) throws Exception {
        //Get the WrapsDriver of the WebElement
        WrapsDriver wrapsDriver = (WrapsDriver) element;

        //Get the entire Screenshot from the driver of passed WebElement
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);

        //Create an instance of Buffered Image from captured screenshot
        BufferedImage img = ImageIO.read(screen);

        // Get the Width and Height of the WebElement using
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        //Create a rectangle using Width and Height
        Rectangle rect = new Rectangle(width, height);

        //Get the Location of WebElement in a Point. ....
        //This will provide X & Y co-ordinates of the WebElement
        Point p = element.getLocation();
        //Create image by for element using its location and size.
        //This will give image data specific to the WebElement
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        //Write back the image data for element in File object
        ImageIO.write(dest, "png", screen);
        //Return the File object containing image data
        return screen;
    }

}