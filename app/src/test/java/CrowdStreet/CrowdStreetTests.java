package CrowdStreet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrowdStreetTests {
    @Test
    public void LoadCrowdStreetPage() {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://test.crowdstreet.com");
        
        String expectedResult = "Marketplace | CrowdStreet";
        String actualResutl = driver.getTitle();
        Assert.assertEquals(expectedResult, actualResutl);
        driver.quit();
    }
    
}





