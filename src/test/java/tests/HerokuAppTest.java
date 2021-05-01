package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuAppTest {

    @Test
    public void herokuAppTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement imputFild = driver.findElement(By.xpath("//*[@type='number']"));
        imputFild.sendKeys("20");
        String actualText = imputFild.getAttribute("value");
        Assert.assertEquals(actualText, "20");
        imputFild.sendKeys(Keys.ARROW_UP);
        actualText = imputFild.getAttribute("value");
        Assert.assertEquals(actualText, "21");

        //driver.quit();
    }

}
