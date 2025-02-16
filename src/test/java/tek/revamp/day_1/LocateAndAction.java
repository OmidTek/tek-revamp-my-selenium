package tek.revamp.day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocateAndAction {
//mohammad_2024@tekschool.com
    //Password@123
    public static void main(String [] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        //Implicitly Wait One time setup for Driver and global wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Locate
        By signInLocator = By.linkText("Sign in");
        //Find
        WebElement signInElement = wait.until(ExpectedConditions
                .elementToBeClickable(signInLocator));
        //Action
        signInElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
        .sendKeys("mohammad_2024@tekschool.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
        .sendKeys("Password@123");


       wait.until(ExpectedConditions
               .elementToBeClickable(By.className("login__submit"))).click();

        driver.quit();
    }
}
