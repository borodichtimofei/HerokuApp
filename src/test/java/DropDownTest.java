import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropDownTest extends BaseTest {

    @Test
    public void dropDown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        String firstOption = select.getOptions().get(0).getText();
        assertEquals(firstOption, "Please select an option", "message not correct");
        String secondOption = select.getOptions().get(1).getText();
        assertEquals(secondOption, "Option 1", "message not correct");
        String thirdOption = select.getOptions().get(2).getText();
        assertEquals(thirdOption, "Option 2", "message not correct");
        assertEquals(select.getOptions().size(), 3, "number elements not correct");
        assertFalse(select.getOptions().get(0).isEnabled());
        select.selectByVisibleText("Option 1");
        assertTrue(select.getOptions().get(1).isSelected());

    }
}
