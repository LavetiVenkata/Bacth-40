package base_util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Xls_Reader.Xls_Reader;

public class Common_Util {
	
	public static WebDriver driver;
	public static WebElement element;
	public static Xls_Reader xls = new Xls_Reader ("C:\\Users\\naveen\\Documents\\documentations of industries\\Book.xlsx");
	public static String result;
	public static int rowCount;
	public static int rowNum;
	public static String runmode;
	public static String actionname;
	public static String xpathVal;
	public static String data;
	

}
