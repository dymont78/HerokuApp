package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppDynamicControlsTest extends HerokuBaseTest {

    @Test
    public void herokuAppCheckBoxDCTest () {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertTrue(driver.findElement(By.id("checkbox")).isEnabled());
        driver.findElement(By.id("checkbox-example")).findElement(By.xpath("//*[@type='button']")).click();
        driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        int numberOfElement = driver.findElements(By.id("checkbox")).size();
        Assert.assertEquals(numberOfElement, 0);
    }

    @Test
    public void herokuAppImputTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='text']")).getAttribute("disabled"), "true");
        driver.findElement(By.xpath("//*[@id='input-example']//*[@type='button']")).click();
        driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        boolean isEnabletImput = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        Assert.assertTrue(isEnabletImput);
    }
}
