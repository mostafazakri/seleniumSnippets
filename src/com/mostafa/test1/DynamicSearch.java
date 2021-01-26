package com.mostafa.test1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicSearch {
	//------------- How to perform Dynamic search by using dynamic xpath --------------------\\
		//-------------https://demo.codeforgeek.com/ajaxbox/ ------------------------------------\\
		/*
		 * Steps:
		 *      1-Google Search --pick a value from suggestions
		 *      2-Search using xpath
		 *      3-get the total count of suggestions
		 *      4-Use if condition to match value
		 *      5-click on matched value
		 */
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
    WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("https://www.google.ca/");
	driver.findElement(By.name("q")).sendKeys("Testing");
	List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div/span"));
	System.out.println("Le nombre total de suggestions est: " + list.size());
	for(int i =0; i< list.size(); i++) {
	    System.out.println(list.get(i).getText());
	    if(list.get(i).getText().contains("internet speed")){
	        list.get(i).click();
	        break;
	    }
	}
}
}
