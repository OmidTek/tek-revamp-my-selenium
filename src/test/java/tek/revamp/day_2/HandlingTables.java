package tek.revamp.day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingTables {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("username"))
                .sendKeys("supervisor");
        driver.findElement(By.name("password"))
                .sendKeys("tek_supervisor");

        driver.findElement(By.xpath("//button[text()='Sign In']"))
                .click();

        driver.findElement(By.linkText("Accounts"))
                .click();

        List<WebElement> emailColumnsElements = driver.findElements(
                By.xpath("//table/tbody/tr/td[2]"));

        Thread.sleep(2000);

        for (int row = 1; row <=emailColumnsElements.size(); row++) {
           String email = emailColumnsElements.get(row-1).getText();

           if(email.equalsIgnoreCase("Dalton.Batz4247@happy.ca")) {
               String xpath = "//table/tbody/tr["+row+"]/td[7]/button";
               driver.findElement(By.xpath(xpath)).click();
               break;
           }
        }


        Thread.sleep(2000);

    }
}
