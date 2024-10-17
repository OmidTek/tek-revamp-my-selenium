package tek.revamp.day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/drag-drop");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2000);

        By sourceLocator = By.xpath("//h2[text()='To do']/following-sibling::div/div/div[1]");

        By targetLocator = By.xpath("//h2[text()='In Progress']/following-sibling::div/div");
        WebElement source  =driver.findElement(sourceLocator);
        WebElement target  =driver.findElement(targetLocator);
        Actions action = new Actions(driver);

        action.dragAndDrop(source, target)
                .build().perform();

        //Right Click
//        action.contextClick(source).build().perform();
    }
}
