import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class CdpcommandsTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/User/Downloads/KGV/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools =driver.getDevTools();
		//you have to create session to send the command through code to the browser under test
		devtools.createSession();
		Map develop = new HashMap();
		develop.put("width", 600);
		develop.put("height", 1000);
		develop.put("deviceScaleFactor", 50);
		develop.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", develop);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();

	}

}
