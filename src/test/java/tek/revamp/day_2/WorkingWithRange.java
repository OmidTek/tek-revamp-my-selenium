package tek.revamp.day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WorkingWithRange {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/inputs");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(2000);

        for(int i = 0; i < 20 ; i++) {
            driver.findElement(By.name("range")).sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
