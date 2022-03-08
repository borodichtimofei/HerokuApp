import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTest extends BaseTest{

    @Test
    public void hover (){
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(element).build().perform();
        String name = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
        assertEquals(name, "name: user1");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        boolean isDisplayed = driver.findElement(By.xpath("/html/body/h1")).isDisplayed();
        assertTrue(isDisplayed, "data displayed");
        String error = driver.findElement(By.xpath("/html/body/h1")).getText();
        assertEquals(error, "Not Found", "data displayed");

        driver.get("http://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(element).build().perform();
        name = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText();
        assertEquals(name, "name: user2");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        isDisplayed = driver.findElement(By.xpath("/html/body/h1")).isDisplayed();
        assertTrue(isDisplayed, "data displayed");
        error = driver.findElement(By.xpath("/html/body/h1")).getText();
        assertEquals(error, "Not Found", "data displayed");

        driver.get("http://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(element).build().perform();
        name = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText();
        assertEquals(name, "name: user3");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        isDisplayed = driver.findElement(By.xpath("/html/body/h1")).isDisplayed();
        assertTrue(isDisplayed, "data displayed");
        error = driver.findElement(By.xpath("/html/body/h1")).getText();
        assertEquals(error, "Not Found", "data displayed");

    }

}
