package tek.revamp.selenium4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDemo {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)) ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println(driver.getTitle());

        WebElement serarchBox = driver.findElement(By.id("small-searchterms"));

        serarchBox.sendKeys("laptop" , Keys.ENTER);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.cssSelector("input[value='Add to cart']")))).click();

          
        Wait<WebDriver> fluentWait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.cssSelector("input[value='Add to cart']")))).click();







    }
}
