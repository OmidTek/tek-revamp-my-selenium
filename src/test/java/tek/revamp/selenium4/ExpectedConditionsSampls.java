package tek.revamp.selenium4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExpectedConditionsSampls {


        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver(); // Use your preferred WebDriver

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. elementToBeClickable()
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
            clickableElement.click();

            // 2. visibilityOf()
            WebElement visibleElement = wait.until(ExpectedConditions.
                    visibilityOf(driver.findElement(By.id("searchBox"))));
            visibleElement.sendKeys("Selenium");

            // 3. presenceOfElementLocated()
            WebElement presentElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("someElement")));

            // 4. invisibilityOfElementLocated()
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingSpinner")));

            // 5. alertIsPresent()
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

            // 6. textToBePresentInElement()
            wait.until(ExpectedConditions.
                    textToBePresentInElement(driver.findElement(By.id("someElement")), "Success"));

            // 7. frameToBeAvailableAndSwitchToIt()
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frameID")));

            // 8. elementToBeSelected()
            wait.until(ExpectedConditions.elementToBeSelected(By.id("checkbox")));

            // 9. numberOfElementsToBe()
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".result-item"), 5));

            // 10. elementLocatedToBeClickable()
            WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
            clickableButton.click();

            // 11. stalenessOf()
            WebElement element = driver.findElement(By.id("someElement"));
            wait.until(ExpectedConditions.stalenessOf(element));

            // 12. visibilityOfAllElements()
            List<WebElement> elements = wait.until(ExpectedConditions.
                    visibilityOfAllElements(driver.findElements(By.className("item"))));

            // 13. textToBePresentInElementValue()
            wait.until(ExpectedConditions.textToBePresentInElementValue(By.name("searchBox"), "Selenium"));

            // Clean up
            driver.quit();
        }
    }


