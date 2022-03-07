import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void sortableDataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement elementFirst = driver.findElements(By.xpath("//table//tr[1]//td[1]")).get(0);
        String string = elementFirst.getText();
        assertEquals(string, "Smith", "cell data not correct");
        WebElement elementSecond = driver.findElements(By.xpath("//table//tr[2]//td[2]")).get(0);
        string = elementSecond.getText();
        assertEquals(string, "Frank", "cell data not correct");
        WebElement elementThird = driver.findElements(By.xpath("//table//tr[3]//td[3]")).get(1);
        string = elementThird.getText();
        assertEquals(string, "jdoe@hotmail.com", "cell data not correct");

    }
}
