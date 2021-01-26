package com.mostafa.test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCalendrier {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		/*WebElement dateBox = driver.findElement(By.id("travel_date"));
		dateBox.sendKeys("10202020");
        dateBox.sendKeys(Keys.TAB);
        */
		
		driver.findElement(By.id("travel_date")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("February")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }
		
		List<WebElement> dates = driver.findElements(By.className("day"));
 		int count = dates.size();
		
		for (int i = 0; i < count; i++) {
	         String text = driver.findElements(By.className("day")).get(i).getText();
	         if (text.equalsIgnoreCase("22")) {
	             driver.findElements(By.className("day")).get(i).click();
	             break;
	         }
	    }
	}

}
