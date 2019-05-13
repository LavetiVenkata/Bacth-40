package Selenium_Commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Using_Webdriver {

	WebDriver driver;
	JavascriptExecutor jse;
	public void invokeBrowser()
	{
		
		try {
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver","C:\\Users\\naveen\\eclipse-workspace\\testng_project\\src\\Selenium_Commands\\Config_drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.get("https://www.ebay.com");
			driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("cameras");
			driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 100)");
			driver.findElement(By.xpath("//input[@aria-label='Nikon']")).click();
           } catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
		Using_Webdriver a =new Using_Webdriver();
		a.invokeBrowser();
		
	}

}
