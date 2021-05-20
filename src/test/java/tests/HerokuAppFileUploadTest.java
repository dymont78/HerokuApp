package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppFileUploadTest extends HerokuBaseTest{

    @Test
    public void herokuAppUploadFileTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("D:\\qa_teach\\HerokuApp\\src\\test\\resources\\Screenshot_2.jpg");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("uploaded-files"))));
        String getFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(getFileName, "Screenshot_2.jpg");
    }
}
