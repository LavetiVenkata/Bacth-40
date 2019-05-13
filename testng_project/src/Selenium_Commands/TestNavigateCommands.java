package Selenium_Commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNavigateCommands {
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
				driver.navigate().to("https://www.myntra.com");
				driver.findElement(By.xpath("//a[@data-group='home-&-living']")).click();
				driver.findElement(By.xpath("//a[@href='/home-decor-wall-art']")).click();
				driver.navigate().back();
				Thread.sleep(2000);
				driver.navigate().forward();
				Thread.sleep(2000);
                driver.navigate().refresh();
                Thread.sleep(2000);
	            driver.close();

				} catch (Exception e) {
				e.printStackTrace();
			}
		}
 public static void main(String[] args) {
	 TestNavigateCommands a =new TestNavigateCommands();
	 a.invokeBrowser();
     
		
		
	}

}
