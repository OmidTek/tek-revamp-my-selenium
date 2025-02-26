package tek.revamp.PracticeOnly;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionAlertEnter {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)) ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println(driver.getTitle());
        Actions actions=new Actions(driver);

        WebElement serarchBox = driver.findElement(By.id("small-searchterms"));
//        serarchBox.sendKeys(("Test"));
//        actions.sendKeys(Keys.ENTER).perform();

            // with out action class
      //  serarchBox.sendKeys("Tset" , Keys.ENTER);


        serarchBox.click();
        serarchBox.sendKeys(Keys.ENTER);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
}
