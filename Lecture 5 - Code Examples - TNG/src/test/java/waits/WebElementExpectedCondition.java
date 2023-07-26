package waits;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WebElementExpectedCondition implements ExpectedCondition<WebElement> {

    @Nullable
    @Override
    public WebElement apply(@Nullable WebDriver driver) {
        return driver.findElement(By.xpath("//div[contains(text(),'Nunc nibh tortor')]"));
    }
}
