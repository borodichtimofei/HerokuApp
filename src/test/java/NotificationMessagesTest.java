import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void notificationMessages() {

        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        element.click();
        boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"flash\"]")).isDisplayed();
        assertTrue(isDisplayed);

        String message = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().trim().replace("\\n", "");
        String newMessage = message.substring(0, 17);
        assertEquals(newMessage, "Action successful");
    }
}
