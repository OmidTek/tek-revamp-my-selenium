package tek.revamp.day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class HandlingMultipleTab {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String mainWindowId = driver.getWindowHandle();

        driver.findElement(By.linkText("Test Selenium")).click();

        Set<String> windowIds  = driver.getWindowHandles();
        for(String id: windowIds) {
            if (!id.equals(mainWindowId)) {
                driver.switchTo().window(id);
                break;
            }
        }

        driver.findElement(By.linkText("Inputs")).click();

        driver.findElement(By.name("text")).sendKeys("Something");
        Thread.sleep(2000);

        driver.close();

        driver.switchTo().window(mainWindowId);


       String text=  driver.findElement(By.className("top-nav__logo")).getText();
        System.out.println(text);

        driver.quit();
    }
}
