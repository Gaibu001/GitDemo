import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class GeoLocationTest {
	public static void main(String[] args) throws InterruptedException {		
		// Set up ChromeOptions to include geolocation data and set the language to Spanish       
		System.setProperty("webdriver.chrome.driver","C:/Users/User/Downloads/KGV/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();       
		options.addArguments("--enable-features=Geolocation"); 
		options.addArguments("--lang=es"); // Set the browser language to Spanish
		ChromeDriver driver = new ChromeDriver(options);
		//Set the geolocation using CDP       
        double latitude = 40;       
        double longitude = 3;       
        double accuracy = 1;       
        DevTools devTools = ((ChromeDriver) driver).getDevTools();        
        devTools.createSession();       
        devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude), Optional.of(longitude), Optional.of(accuracy)));
        //Perform a Google search for "Netflix is open Spanish language"       
        driver.get("https://www.google.com");       
        WebElement searchBox = driver.findElement(By.name("q"));       
        searchBox.sendKeys("Netflix");       
        searchBox.submit();
        //Wait for the results to load and perform other actions as needed     
       // Thread.sleep(5000);      
        driver.findElement(By.cssSelector(".LC20lb")).click();// Close the browser       // driver.quit();    }}
	}
        
}   