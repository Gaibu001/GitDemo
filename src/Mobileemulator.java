import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class Mobileemulator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/User/Downloads/KGV/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools =driver.getDevTools();
		devtools.createSession();
		//send command to CDP methods -----> CDP methods will invoke and get access to chrome dev tools
		devtools.send(Emulation.setDeviceMetricsOverride(600,1000, 50, true, Optional.empty(),Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();
		
		

	}

}
