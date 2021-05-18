package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HerokuAppIFrameTest extends HerokuBaseTest{
    public  void herokuAppIFrameTest(){
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");
        driver.switchTo().parentFrame();
    }
}
