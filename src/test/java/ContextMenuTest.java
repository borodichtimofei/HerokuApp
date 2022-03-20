import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Alert alert = driver.switchTo().alert();
        String textInAlert = alert.getText();
        assertEquals(textInAlert, "You selected a context menu");
        alert.accept();
    }
}
