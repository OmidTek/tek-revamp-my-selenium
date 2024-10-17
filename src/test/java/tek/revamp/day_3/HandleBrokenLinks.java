package tek.revamp.day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class HandleBrokenLinks {

    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By anchorLocator = By.tagName("a");
       List<WebElement> elements = driver.findElements(anchorLocator);

       for(WebElement element : elements) {
          String href = element.getAttribute("href");
          if (href != null) {
              HttpClient client = HttpClient.newHttpClient();
              HttpRequest request = HttpRequest.newBuilder()
                      .uri(URI.create(href))
                      .GET()
                      .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println(response.statusCode() + " Broken Link " + href);
            }
          }else {
              System.out.println("Null Link");
          }
       }

       driver.quit();
    }
}
