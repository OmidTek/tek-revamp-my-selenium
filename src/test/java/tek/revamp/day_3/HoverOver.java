package tek.revamp.day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HoverOver {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/hover");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        boolean isDisplayed = driver.findElement(By.id("firstPerson")).isDisplayed();
        System.out.println(isDisplayed);
        WebElement element = driver.findElement(By.id("image1"));
        Actions action = new Actions(driver);
        Action hoverOverAction = action.moveToElement(element)
                .build();

        hoverOverAction.perform();


        isDisplayed = driver.findElement(By.id("firstPerson")).isDisplayed();
        System.out.println(isDisplayed);
        driver.quit();

    }
}
