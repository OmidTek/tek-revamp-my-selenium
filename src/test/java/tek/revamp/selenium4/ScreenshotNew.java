package tek.revamp.selenium4;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class ScreenshotNew {

    public static void main (String [] args) throws IOException {
        WebDriver driver= new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        // time stamp
        Calendar cal=Calendar.getInstance();
        Date time = cal.getTime();
       String timeStamp=time.toString().replaceAll(":","").replaceAll(" ","").replaceAll("[a-zA-Z]","");
        System.out.println(timeStamp);


        // how to take Screenshot

         File toscaHomePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(toscaHomePage, new File("./Screenshots/"+"toscaHomePage"+timeStamp+".jpg"));

         // Element screenshot

        WebElement searchBox=driver.findElement(By.cssSelector("input#small-searchterms"));
        searchBox.sendKeys("Hello");

        File searchBoxScrrenshot =searchBox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(searchBoxScrrenshot,new File("./Screenshots/"+"element"+timeStamp+".jpg"));

        // Take fullpage screenshot  with aShot library

        Screenshot fullpage =new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(2000))//Scrolls and captures
                .takeScreenshot(driver);

        ImageIO.write(fullpage.getImage(),"jpg",
                new File("./Screenshots/"+"fullpage"+timeStamp+".jpg"));








    }
}
