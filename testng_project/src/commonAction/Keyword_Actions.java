package commonAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import base_util.Common_Util;


public class Keyword_Actions extends Common_Util{

	public static void executeKeywords (String testName) {
		try {
			rowCount = xls.getRowCount("TestCase_Steps");
			
			for (rowNum = 2; rowNum <= rowCount; rowNum ++) {
				
				if (testName.equalsIgnoreCase(xls.getCellData("TestCase_Steps", "TestCase_Name", rowNum))) {
					
					runmode = xls.getCellData("TestCase_Steps", "RunMode", rowNum);
					if (runmode.equalsIgnoreCase("Y")) {
						
						actionname = xls.getCellData("TestCase_Steps", "Action_Name", rowNum);
						xpathVal = xls.getCellData("TestCase_Steps", "Object_Xpath", rowNum);
						data = xls.getCellData("TestCase_Steps", "Test_Data", rowNum);
						
						if (actionname.equalsIgnoreCase("openBrowser"))
							result = openBrowser(data);
						
						if (actionname.equalsIgnoreCase("nagivateUrl"))
							result = nagivateUrl(data);
						
						if (actionname.equalsIgnoreCase("enterText"))
							result = enterText(xpathVal, data);
						
						if (actionname.equalsIgnoreCase("selectItem"))
							result = selectItem(xpathVal, data);
						
						if (actionname.equalsIgnoreCase("clickButton"))
							result = clickButton(xpathVal);
						
						if (actionname.equalsIgnoreCase("closeBrowser"))
							result = closeBrowser();
					}
					xls.setCellData("TestCase_Steps", "Results", rowNum, result);
				}
			}
					
		}catch (Exception l) {
			l.printStackTrace();
		}
	}
	
    //open browser
    public static String openBrowser(String browser)
	{
		try {
			if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\naveen\\eclipse-workspace\\amazon_selenium\\Config_drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("IE")) {
			        System.setProperty("webdriver.ie.driver","C:\\Users\\naveen\\eclipse-workspace\\amazon_selenium\\Config_drivers\\IEDriverServer.exe");
                    driver =new InternetExplorerDriver();
				}//write code for IE
			else if(browser.equalsIgnoreCase("gecko")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\naveen\\eclipse-workspace\\amazon_selenium\\Config_drivers\\geckodriver.exe");
				 driver = new FirefoxDriver();
				
			}else {
				System.out.println("Invalid Browser Selection");
			} 
			System.out.println("User Is Able To Open "+ browser +" browser ");	
			return "PASS";
			}catch(Exception e) {
		     e.printStackTrace();
				System.out.println("User Is Not Able To Open "+ browser +" browser ");	
				return "FAIL";
				}
		
	        }		
	
	//launch the application
	public static String nagivateUrl(String url)
	{
		try {
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("User is able to lauch the appplication");
			return "PASS";
			}
	catch (Exception e) {
		  e.printStackTrace();
		System.out.println("User is not able to lauch the appplication");
		return "FAIL";
		}
	}
    
	//Enter data
	public static String enterText(String xpathValue,String textValue) {
		try {
			//find an element
		element = driver.findElement(By.xpath(xpathValue));
		//enter value to the text box
		element.sendKeys(textValue);
		return "PASS";
	}catch(Exception e){
		e.printStackTrace();
		return "FAIL";
		}
}
	
	//click button
	public static String clickButton(String xpathValue) {
		try {
			//find element
			element =driver.findElement(By.xpath(xpathValue));
			//click the element
			element.click();
			return "PASS";
           }catch(Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	//select item
	public static String selectItem(String xpathValue,String SelectItem) {
		try {
			
			//find an element
			element =driver.findElement(By.xpath(xpathValue));
			//put the element into select option
			Select sel = new Select(element);
			sel.selectByVisibleText(SelectItem);
			return "PASS";
			}catch(Exception e){
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	//close browser
	public static String closeBrowser() {
			try {
				driver.close();
				driver.quit();
				System.out.println("User Is able to close the browser");
				return "PASS";
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("User Is not able to close the browser");
				return "FAIL";

			}
			 
		}	


}
