package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuAppTest extends HerokuBaseTest {

    @Test
    public void herokuAppTest() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement imputFild = driver.findElement(By.xpath("//*[@type='number']"));
        imputFild.sendKeys("20");
        String actualText = imputFild.getAttribute("value");
        Assert.assertEquals(actualText, "20");
        imputFild.sendKeys(Keys.ARROW_UP);
        actualText = imputFild.getAttribute("value");
        Assert.assertEquals(actualText, "21");
    }

    @Test
    public void herokuAppAddRemoveTest() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='elements']//button[@class='added-manually']"));
        System.out.println("Количество оставшихся элементов: " + elements.size());
        Assert.assertEquals(elements.size(), 2);
    }

}
