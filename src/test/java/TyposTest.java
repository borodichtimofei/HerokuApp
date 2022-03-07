import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest {

    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement elementFirst = driver.findElements(By.tagName("p")).get(1);
        String stringUnderRefresh = elementFirst.getText();
        Assert.assertEquals(stringUnderRefresh, "Sometimes you'll see a typo, other times you won't.", "string not correct");
        driver.navigate().refresh();
        WebElement elementSecond = driver.findElements(By.tagName("p")).get(1);
        String stringAfterRefresh = elementSecond.getText();
        Assert.assertEquals(stringAfterRefresh, "Sometimes you'll see a typo, other times you won,t.", "string not correct");

    }
}
