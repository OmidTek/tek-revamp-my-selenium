package tek.revamp.day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicDropdown {

    public static void main(String[] args) throws InterruptedException {
        //Dynamic Element
        //An element get attribute values dynamically
        //Solution Xpath

        //2) Elements Get Values dynamically
        //Solution is Xpath

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(By.name("q")).sendKeys("Teksc");


       List<WebElement> listElements = driver.findElements(
               By.xpath("//div[@role='presentation']/ul/li"));


        for(int i = 0; i < listElements.size(); i++) {
            String text = listElements.get(i).getText();
            if (text.toLowerCase().contains("tekschool")) {
                listElements.get(i).click();
                break;
            }
        }

        Thread.sleep(5000);
        driver.quit();
        //div[@role='presentation']/ul/li
    }
}
