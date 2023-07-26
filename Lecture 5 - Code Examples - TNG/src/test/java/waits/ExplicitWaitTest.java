package waits;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import waits.utils.WaitTool;


public class ExplicitWaitTest {
 	
	@Test
	public void testExplicitWait()
 	{
		System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/ajax/demo.html");
 		
        try {
 			WebElement page4button = driver.findElement(By.linkText("Page 4"));
 			page4button.click();
 			

			//IMPORTANT: In CASE YOU USE SELENIUM VERSION 3.141.59 OR BELOW THE EXPLICIT WAIT OBJECT IS BEING
			// INSTANTIATED AS FOLLOWS:
			//WebDriverWait wait = new WebDriverWait(driver, 10);

			//IMPORTANT: In CASE YOU USE SELENIUM VERSION 4.0.0-beta-1 THE EXPLICIT WAIT OBJECT IS BEING
			// INSTANTIATED AS FOLLOWS:
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			//FIRST way of EXPLICIT CUSTOM MADE WAIT:
 			WebElement message = wait.until(new WebElementExpectedCondition());

 			//SECOND way of EXPLICIT CUSTOM MADE WAIT:
// 			WebElement message = wait.until(new ExpectedCondition<WebElement>() {
//				@Nullable
//				@Override
//				public WebElement apply(@Nullable WebDriver input) {
//					return driver.findElement(By.xpath("//div[contains(text(),'Nunc nibh tortor')]"));
//				}
//			});

			//third way of EXPLICIT CUSTOM MADE WAIT:
// 			WebElement message = WaitTool.waitForElementPresent(driver, By.xpath("//div[contains(text(),'Nunc nibh tortor')]"), 5);
 			
 			assertTrue(message.getText().contains("Nunc nibh tortor"));

 		} catch (NoSuchElementException e) {
 			fail("Element not found!!");
 			e.printStackTrace(); 
 		} finally {
 			driver.quit();
 		}
 	}
	
	@Test
	public void testExplicitWaitTitleContains()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");

		//IMPORTANT: In CASE YOU USE SELENIUM VERSION 3.141.59 OR BELOW THE IMPLICIT WAIT IS BEING
		// DEFINED AS FOLLOWS:
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//IMPORTANT: In CASE YOU USE SELENIUM VERSION 4.0.0-beta-1 THE IMPLICIT WAIT IS BEING
		// DEFINED AS FOLLOWS:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Enter a term to search and submit
		WebElement query = driver.findElement(By.name("q"));
		query.sendKeys("selenium");
		query.submit();
		//Create Wait using WebDriverWait. 
		//This will wait for 10 seconds for timeout before title is updated with search term
		//If title is updated in specified time limit test will move to the text step 
		//instead of waiting for 10 seconds

		//IMPORTANT: In CASE YOU USE SELENIUM VERSION 3.141.59 OR BELOW THE EXPLICIT WAIT OBJECT IS BEING
		// INSTANTIATED AS FOLLOWS:
		//WebDriverWait wait = new WebDriverWait(driver, 10);

		//IMPORTANT: In CASE YOU USE SELENIUM VERSION 4.0.0-beta-1 THE EXPLICIT WAIT OBJECT IS BEING
		// INSTANTIATED AS FOLLOWSS:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains("selenium"));
//		wait.until(new TitleContainsExpectedCondition());   this will be the same behavior

		//Verify Title
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
		
		driver.quit();
	}
}
