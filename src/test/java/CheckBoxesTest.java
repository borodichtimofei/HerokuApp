import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTest {

    @Test
    public void checkBoxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement elementFirst = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);
        assertFalse(elementFirst.isSelected(), "Element selected");
        elementFirst.click();
        assertTrue(elementFirst.isSelected(), "Element unselected");
        WebElement elementSecond = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);
        assertTrue(elementSecond.isSelected(), "Element unselected");
        elementSecond.click();
        assertFalse(elementSecond.isSelected(), "Element selected");
    }
}
