package Mytool;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Mytool {
	
	public void html(WebDriver driver,String html){
		((JavascriptExecutor) driver).executeScript(html);
	}
}
