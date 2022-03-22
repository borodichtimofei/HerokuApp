import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        assertTrue(driver.findElement(By.cssSelector("[type=checkbox]")).isSelected());

        driver.findElement(By.xpath("//button[text() ='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.id("checkbox")).size();
        assertEquals(numberOfElements, 0, "Element is displayed  on the page");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        Assert.assertFalse(driver.findElement(By.tagName("input")).isEnabled());
        driver.findElement(By.xpath("//button[text() ='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(message, "It's enabled!");
        Assert.assertTrue(driver.findElement(By.tagName("input")).isEnabled());
    }
}
