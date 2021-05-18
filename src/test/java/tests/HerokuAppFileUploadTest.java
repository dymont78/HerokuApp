package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HerokuAppFileUploadTest extends HerokuBaseTest{
    public void herokuAppUploadFileTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("D:\\qa_teach\\HerokuApp\\src\\test\\resources\\Screenshot_2.jpg");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("uploaded-files"))));
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "Screenshot_2.jpg");
    }
}
