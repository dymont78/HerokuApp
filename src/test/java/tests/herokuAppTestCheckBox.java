package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class HerokuAppTestCheckBox {
    public void herokuAppTestCheckBox(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/checkboxes']")).click();
        WebElement firstCheckBox = driver.findElement(By.cssSelector("form input:first-child"));
        WebElement secondCheckBox = driver.findElement(By.cssSelector("form input:last-child"));
        boolean isCheckBoxActuals = firstCheckBox.isSelected();
        if (!isCheckBoxActuals) System.out.println("Checkbox1 unchecked");
        firstCheckBox.click();
        isCheckBoxActuals = firstCheckBox.isSelected();
        if (isCheckBoxActuals) System.out.println("Checkbox1 checked");
        isCheckBoxActuals = secondCheckBox.isSelected();
        if (isCheckBoxActuals) System.out.println("Checkbox2 checked");
        secondCheckBox.click();
        isCheckBoxActuals = secondCheckBox.isSelected();
        if (!isCheckBoxActuals) System.out.println("Checkbox2 unchecked");
        driver.quit();
    }
}
