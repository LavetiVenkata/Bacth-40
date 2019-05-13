package Selenium_Commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {
	
	 static WebDriver driver;
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
				driver.get("https://www.amazon.com");
				String titleOfThePage =driver.getTitle();
				System.out.println("Title Of The Page is" +titleOfThePage);
				driver.findElement(By.linkText("Today's Deals")).click();
				String curentUrl =driver.getCurrentUrl();
				System.out.println("The Current Url Is" + curentUrl);
				System.out.println("The Current Page Source Is" +driver.getPageSource());
				} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	  public static void main (String[] args) {
	    
	TestGetCommands obj = new TestGetCommands();
	obj.invokeBrowser();

		
	}

	 }	
		
		
		
		
	
	

