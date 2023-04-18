package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the username field element and type username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Find the password field element and type password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login button element and click
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //Verify the text “PRODUCTS”
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedText = "Products";
        Assert.assertEquals("Message not displayed successfully", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Find the username field element and type username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Find the password field element and type password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login button element and click
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualSize = products.size();
        int expectedSize = 6;
        Assert.assertEquals("There are not 6 products", expectedSize, actualSize);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
