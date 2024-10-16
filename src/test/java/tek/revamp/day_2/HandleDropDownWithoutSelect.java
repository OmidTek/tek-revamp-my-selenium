package tek.revamp.day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleDropDownWithoutSelect {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://dev.retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.name("email")).sendKeys("mohammad@tekschool.us");
        driver.findElement(By.name("password")).sendKeys("password123");

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        driver.findElement(By.xpath("//button[contains(@class,'ant-dropdown-trigger')]"))
                .click();

        driver.findElement(By.linkText("Account Settings")).click();

        driver.findElement(By.linkText("Wallet")).click();

        driver.findElement(By.xpath("//button[@aria-label='add-payment']"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.id("provider")).click();

        List<WebElement> dropDownElements = driver.findElements(
                By.xpath("//div[@class='ant-select-item-option-content']/span"));
        Thread.sleep(1000);
        for (WebElement element : dropDownElements) {
            String text = element.getText();
            if (text.equalsIgnoreCase("VISA")) {
                element.click();
                break;
            }
        }

    }
}
