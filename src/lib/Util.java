package lib;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {

    public WebElement pagesync(WebDriver page, String locator){
        Wait<WebDriver> pause = new WebDriverWait(page, Duration.ofSeconds(20));
        WebElement object = pause.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locator)));
        return object;
    }

    public void performClick(WebDriver page,String locator){
        System.out.println("performing the click on the object");
        WebElement element = pagesync(page,locator);
        Actions ui = new Actions(page);
        ui.moveToElement(element).click().perform();
        System.out.println("Clicked on the object and waiting for page sync");
    }
}
