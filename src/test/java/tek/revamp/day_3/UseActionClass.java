package tek.revamp.day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class UseActionClass {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        driver.findElement(
//                By.xpath("//button[@id='alertBtn']/following-sibling::button[1]"))
//                .click();

       WebElement element = driver.findElement(
                By.xpath("//button[@id='alertBtn']/following-sibling::button[1]"));

        Actions action = new Actions(driver);

        action.moveToElement(element)
                        .build().perform();

        action.click(element)
                .build().perform();



    }
}
