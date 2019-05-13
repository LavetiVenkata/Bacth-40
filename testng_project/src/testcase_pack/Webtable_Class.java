package testcase_pack;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable_Class {
	
	//working with web table in selenium
	public static void main(String[] args) throws Throwable {
	    	WebDriver wd;
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\naveen\\eclipse-workspace\\amazon_selenium\\Config_drivers\\chromedriver.exe");
		  wd= new ChromeDriver();
		  wd.manage().window().maximize();

	        wd.get("http://money.rediff.com/gainers/bsc/dailygroupa?"); 
	        
	        //No.of Columns
	        List<WebElement>  col = wd.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	        System.out.println("No of cols are : " +col.size());
	      // for each loop
	        for(WebElement el:col) {
	        	System.out.println(el.getText());
	        	String a =el.getText();
	        	if (a.equalsIgnoreCase("Group")) {
	        		
	        		el.click();
	        		// Create the  JavascriptExecutor object
	        		  JavascriptExecutor js=(JavascriptExecutor) wd; 
	        		  
	        		// call the executeScript method
	        		  js.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", el);
	        	}
	        }
	        Thread.sleep(2000);
	        //No.of rows 
	        List  rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
	        System.out.println("No of rows are : " + rows.size());
	        wd.close();
	    }

}
