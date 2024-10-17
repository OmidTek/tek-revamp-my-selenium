package tek.revamp.day_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleJavaScriptAlert {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2000);
        driver.findElement(By.id("promptBtn"))
                .click();

        //Switch to Alert with switchTo
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.sendKeys("Mohammad");

        //Cancelling Alrt
//        alert.dismiss();

        //Confirm
        alert.accept();

        Thread.sleep(4000);

        String message =driver.findElement(By.id("message")).getText();
        System.out.println(message);
        driver.quit();

    }
}
