package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not navigated to Log in page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Jaina123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Jaina123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();
        String expectedMessage = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Log out text is not displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Jaina12@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Jaina12");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();
        String expectedMessage = "‘Login was unsuccessful.\n" +
                "Please correct the errors and try again. No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error Message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        close();
    }
}
