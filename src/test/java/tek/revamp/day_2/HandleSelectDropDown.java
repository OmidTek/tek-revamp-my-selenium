package tek.revamp.day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleSelectDropDown {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.partialLinkText("Create Primary"))
                .click();
        Thread.sleep(1000);
       WebElement titleElement = driver.findElement(By.name("title"));
        Select titleSelect = new Select(titleElement);
        titleSelect.selectByVisibleText("Mr.");


       WebElement statusElement = driver.findElement(By.id("maritalStatus"));
       Select statusSelect = new Select(statusElement);
       statusSelect.selectByValue("DIVORCED");

       WebElement genderElement = driver.findElement(By.name("gender"));
       Select genderSelect = new Select(genderElement);
       genderSelect.selectByIndex(3);

//        List<WebElement> options = genderSelect.getOptions();

        Thread.sleep(5000);
        driver.quit();
    }
}
