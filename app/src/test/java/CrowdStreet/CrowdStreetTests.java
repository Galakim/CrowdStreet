package CrowdStreet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    
    @Test
    public void RegisterForCreateAnAccount() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://test.crowdstreet.com");
        
        WebElement registerButton = driver.findElement(By.xpath("//div[@class='css-108j06w']/a[@class='_button_d2f0c _flat_d2f0c _button_d2f0c _squared_d2f0c _primary_d2f0c join-button']"));
        registerButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        
        WebElement firstNameField = driver.findElement(By.id("firstName"));                                                                                                     
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Doe");

        WebElement emailAdressfield = driver.findElement(By.id("email"));
        emailAdressfield.sendKeys("johndoe@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("qwERTY123!");

        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        confirmPasswordField.sendKeys("qwERTY123!");

        WebElement accreditedInvestorField = driver.findElement(By.id("accreditedNo"));
        accreditedInvestorField.click();

        WebElement termnsAndConditionsField = driver.findElement(By.id("hasAgreedTos"));
        termnsAndConditionsField.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();
    
        //The "Create an Account" button is not clickable.I used diferent locators and attributes.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='submit-button']")));
        
        String expectedResult = "Hi John";
        String actualResult = driver.findElement(By.xpath("//div[@class='tablet-menu css-eullop']//abbr[@class='head-link']")).getText(); 
        
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }    
}


