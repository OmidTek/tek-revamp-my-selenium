package tek.revamp.day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       String title =  driver.findElement(By.id("title")).getText();
        System.out.println(title);

        driver.switchTo().frame(0);

       String secondText = driver.findElement(By.xpath("//h1[contains(text(), 'nside an iframe')]"))
                .getText();

        System.out.println(secondText);

        driver.switchTo().defaultContent();

        String title2 =  driver.findElement(By.id("title")).getText();
        System.out.println(title2);

        driver.quit();

    }
}
