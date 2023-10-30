package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 {

    @Test
    public static void Testcase03(){
        WebDriver driver =  driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/");

            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space(:('Mobile']"));
            mobileMenu.click();

            WebElement sonyXperiaAddToCart = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]"));
            sonyXperiaAddToCart.click();

            WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("1000");
            WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
            updateButton.click();
            WebElement errorMessage = driver.findElement(By.xpath("//li[@class='error-msg']//ul//li"));

            Assert.assertEquals(errorMessage.getText(),"The requested quantity for \"Sony Xperia\" is not available.");

            WebElement emptyCartLink = driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]"));
            emptyCartLink.click();
            WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[normalize-space(:('Shopping Cart is Empty']"));

            Assert.assertEquals(emptyCartMessage.getText(),"SHOPPING CART IS EMPTY");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        Testcase03();
    }
}