package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppContextMenuTest extends HerokuBaseTest {
    @Test
    public void herokuAppContextMenuTest(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
        driverWait = (new WebDriverWait(driver, 10));
        driverWait.until(ExpectedConditions.alertIsPresent());
        String stringFromAllert = driver.switchTo().alert().getText();
        Assert.assertEquals(stringFromAllert, "You selected a context menu");
        driver.switchTo().alert().accept();
    }
}
