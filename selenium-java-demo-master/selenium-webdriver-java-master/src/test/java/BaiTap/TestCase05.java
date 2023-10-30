package BaiTap;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 {
      @Test
    public static void Testcase05(){
        String firstName = "Tam";
        String lastName = "Minh";
        String email = "toicungkobt@gmail.com";
        String password = "123456";
        String confirmPassword = password;

        WebDriver driver = driverFactory.getChromeDriver();
        try{

            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);

            registerPage.clickMyAccountLink();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.clickCreateAccountLink();


            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.enterFirtstName(firstName);
            registerPage.enterLastName(lastName);
            registerPage.enterEmail(email);
            registerPage.enterPassword(password);
            registerPage.enterConfirmPassword(confirmPassword);
            registerPage.clickRegisterButton();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            WebElement successMessage = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']"));
            Assert.assertEquals(successMessage.getText(),"Thank you for registering with Main Website Store.");

            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
            tvMenu.click();

            WebElement lgLcdAddToWishlist = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]"));
            lgLcdAddToWishlist.click();

            WebElement shareWishlistLink = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareWishlistLink.click();

            WebElement emailInputWishlist = driver.findElement(By.id("email_address"));
            emailInputWishlist.sendKeys("test@example.com");
            WebElement messageInput = driver.findElement(By.id("message"));
            messageInput.sendKeys("Check out my wishlist!");
            WebElement shareWishlistButton = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
            shareWishlistButton.click();

            WebElement wishlistSharedMessage = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            Assert.assertEquals(wishlistSharedMessage.getText(),"Your Wishlist has been shared.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        Testcase05();
    }
}
