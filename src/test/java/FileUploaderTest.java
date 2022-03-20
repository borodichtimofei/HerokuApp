import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest {

    @Test
    public void fileUploader() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.cssSelector("input[type=file]")).
                sendKeys("C:/Users/Админ/IdeaProjects/HerokuApp/src/test/resources/1.txt");
        driver.findElement(By.id("file-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileName, "1.txt");
    }
}


