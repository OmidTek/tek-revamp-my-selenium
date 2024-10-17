package tek.revamp.day_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlertSecondSolution {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2000);
        driver.findElement(By.id("promptBtn"))
                .click();

        //Switching using WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alert.getText());
        alert.sendKeys("I love coding");
        alert.accept();

        String message =driver.findElement(By.id("message")).getText();
        System.out.println(message);
        driver.quit();

    }
}
