import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class Geolocation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/User/Downloads/KGV/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-features=Geolocation");
		options.addArguments("--lang=es");
		ChromeDriver driver = new ChromeDriver(options);
		DevTools devtools =driver.getDevTools();
		//you have to create session to send the command through code to the browser under test
		devtools.createSession();
		//devtools.send(Emulation.setGeolocationOverride(Optional.of(40),Optional.of(3),Optional.of(1)));
		Map<String,Object>coordinates = new HashMap<String,Object>();
		coordinates.put("latitude",40);
		coordinates.put("longitude",3);
		coordinates.put("accuracy",1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		//driver.get("https://www.google.com/maps");
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix");
		driver.findElement(By.name("q")).submit();
		driver.findElement(By.cssSelector(".LC20lb ")).click();
		

	}

}
