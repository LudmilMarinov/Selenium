package seleniumapi;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExecuteJavaScript {

    @Test   //open class ExecuteJavaScript
    public void testJavaScriptCalls() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String title = (String) js.executeScript("return document.title");
        Assert.assertEquals(title, "Google");

        long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
        Assert.assertEquals(links, 19);

        driver.quit();

    }
}