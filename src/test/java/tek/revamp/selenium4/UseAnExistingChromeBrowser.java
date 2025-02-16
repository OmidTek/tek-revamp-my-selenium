package tek.revamp.selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class UseAnExistingChromeBrowser {

/*
    1)Start Chrome with Remote Debugging Mode:

    Close any running Chrome instances.
    Open Command Prompt (cmd) or Terminal and run:
    chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\selenium-chrome"

    This one only worked (not first one)
    "C:\Program Files\Google\Chrome\Application\chrome.exe" --remote-debugging-port=9222 --user-data-dir="C:\selenium-chrome

    Replace chrome.exe with the full path to Chrome if needed.
    This opens Chrome in debug mode and keeps your existing session.
    2/)un Selenium Java Code to Attach to Chrome
    */

    public static void main (String [] args) throws InterruptedException {

        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");


        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("");




    }
}

