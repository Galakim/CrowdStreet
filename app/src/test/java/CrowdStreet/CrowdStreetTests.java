package CrowdStreet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrowdStreetTests {
    @Test
    public void LoadCrowdStreetPage() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://test.crowdstreet.com");
        
        String expectedResult = "Marketplace | CrowdStreet";
        String actualResutl = driver.getTitle();
        Assert.assertEquals( actualResutl,expectedResult);
        driver.quit();
    }

    @Test
    public void NavigateToCreatAnAccountPage() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://test.crowdstreet.com");

        WebElement registerButton = driver.findElement(By.xpath("//div[@class='css-108j06w']/a[@class='_button_d2f0c _flat_d2f0c _button_d2f0c _squared_d2f0c _primary_d2f0c join-button']"));
                                                                                                                  
        registerButton.click();
        
        driver.findElement(By.id("firstName")).isDisplayed();
        
        String expectedResult = "Create Account | CrowdStreet"; 
        String actualResutl = driver.getTitle();
        Assert.assertEquals(actualResutl, expectedResult);
        driver.quit();
    }
    
}


