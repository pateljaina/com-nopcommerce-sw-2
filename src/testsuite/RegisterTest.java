package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        String expectedMessage = "Register";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Not navigated to Register page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        WebElement radioButton = driver.findElement(By.id("gender-female"));
        radioButton.click();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Jaina");
        WebElement lastName = driver.findElement(By.name("LastName"));
        lastName.sendKeys("Patel");
        WebElement dateOfBirthDay = driver.findElement(By.name("DateOfBirthDay"));
        dateOfBirthDay.sendKeys("7");
        WebElement dateOfBirthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        dateOfBirthMonth.sendKeys("2");
        WebElement dateOfBirthYear = driver.findElement(By.name("DateOfBirthYear"));
        dateOfBirthYear.sendKeys("1986");
        WebElement emailId = driver.findElement(By.id("Email"));
        emailId.sendKeys("pateljaina7@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Jaina123");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("Jaina123");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        String expectedMessage = "Your registration completed";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Invalid Credentials", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        close();
    }
}
