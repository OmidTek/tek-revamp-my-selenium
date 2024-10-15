package tek.revamp.day_1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumAndBrowsers {
/*
Since Selenium Version 4 and above
We don't need to set up Browser drivers manually
 */
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://retail.tekschool-students.com/");

        //Some Driver Options and Configuration

        driver.manage().window().maximize();

        //Close only close 1 tab
        driver.close();

        //Quit will close the browser
        driver.quit();
    }
}
