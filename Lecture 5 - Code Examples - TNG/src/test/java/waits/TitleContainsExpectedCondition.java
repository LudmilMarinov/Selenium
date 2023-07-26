package waits;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TitleContainsExpectedCondition implements ExpectedCondition<Boolean> {
    @Nullable
    @Override
    public Boolean apply(@Nullable WebDriver driver) {
        String actualTitle = driver.getTitle();
        return actualTitle.contains("selenium");
    }
}
