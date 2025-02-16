package tek.revamp.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeLocators {
    
    public static void main (String [] args){

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");

        WebElement logInBtn = driver.findElement(By.linkText("Log in"));
        //getDomAttribute(String name) → Introduced in Selenium 4 to
        // always return the original HTML attribute value.(static)
        String domAttribute = logInBtn.getDomAttribute("class");
        System.out.println("Dom Attribute: "+ domAttribute);

        //✅ getAttribute(String name) → Still works, but it now prefers returning J
        // avaScript-modified values rather than the original HTML. (modified values)
        String attribute = logInBtn.getAttribute("class");
        System.out.println("Attribute: "+ attribute);

        //above(WebElement element)
        //below(WebElement element)
        //toLeftOf(WebElement element)
        //toRightOf(WebElement element)
        //near(WebElement element)
        WebElement right=driver.findElement(RelativeLocator.with(By.className("ico-cart")).toRightOf(By.linkText("Log in")));
        System.out.println("Right Element of login button:  "+right.getText());
        WebElement left=driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(By.linkText("Log in")));
        System.out.println("Left side of login button:  "+left.getText());
        WebElement below=driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.linkText("Log in")));
        System.out.println("below of login button"+below.getAttribute("class"));
        WebElement near=driver.findElement(RelativeLocator.with(By.tagName("a")).near(By.linkText("Log in")));
        System.out.println("near of login button: "+near.getText());



        driver.quit();



    }
    
}
