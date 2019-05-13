package testcase_pack;

import commonAction.Keyword_Actions;

public class TestCase_001 extends Keyword_Actions{

	public static void main(String[] args) throws Throwable {

		openBrowser("chrome");
		nagivateUrl("https://www.amazon.com/");
	    Thread.sleep(2000);
	    selectItem("//select[@id='searchDropdownBox']", "Electronics");
	    Thread.sleep(2000);
	    enterText("//input[@id='twotabsearchtextbox']", "camera");
	    Thread.sleep(2000);
	    clickButton("//input[@value='Go']");
	    Thread.sleep(2000);
	    closeBrowser();
		
		//executeKeywords("TestCase_002");
}
}
