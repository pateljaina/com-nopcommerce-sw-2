package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        WebElement computersTab = driver.findElement(By.linkText("Computers"));
        computersTab.click();
        String expectedMessage = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not navigated to computers page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        WebElement electronicsTab = driver.findElement(By.linkText("Electronics"));
        electronicsTab.click();
        String expectedMessage = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not navigated to electronics page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        WebElement apparel = driver.findElement(By.linkText("Apparel"));
        apparel.click();
        String expectedMessage = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not navigated to Apparel page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        WebElement digitalDownloads = driver.findElement(By.linkText("Digital downloads"));
        digitalDownloads.click();
        String expectedMessage = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not navigated to Digital downloads page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        WebElement books = driver.findElement(By.linkText("Books"));
        books.click();
        String expectedMessage = "Books";
        WebElement actualElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Not navigated to Books", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        WebElement jewelry = driver.findElement(By.linkText("Jewelry"));
        jewelry.click();
        String expectedMessage = "Jewelry";
        WebElement actualElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Not navigated to Jewelry page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        WebElement giftCards = driver.findElement(By.linkText("Gift Cards"));
        giftCards.click();
        String expectedMessage = "Gift Cards";
        WebElement actualElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Not navigated to Gift Cards Page", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        close();
    }
}
