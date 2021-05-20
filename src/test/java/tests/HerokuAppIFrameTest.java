package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppIFrameTest extends HerokuBaseTest{

    @Test
    public  void herokuAppIFrameTest(){
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
        String getTextFromIFrame = driver.findElement(By.id("tinymce")).getText();
        Assert.assertEquals(getTextFromIFrame, "Your content goes here.");
        driver.switchTo().parentFrame();
    }
}
