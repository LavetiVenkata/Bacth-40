package Selenium_Commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elementlocators {

	WebDriver driver;

	public void invokeBrowser(String url)
	{
		
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\naveen\\eclipse-workspace\\testng_project\\src\\Selenium_Commands\\Config_drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.get("https://www.jabong.com/");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ElementLocatorTechniques() {
		//invokeBrowser("https://www.jabong.com/");
		driver.findElement(By.id("search")).sendKeys("Footwear");
		driver.findElement(By.className("top-search-icon hidden-xs")).click();
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		

	}

}
