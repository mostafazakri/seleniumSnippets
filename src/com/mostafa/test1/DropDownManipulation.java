package com.mostafa.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownManipulation {
	public static void main(String[] args) {   
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver=new ChromeDriver();  
        driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");   
		Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));  
		dropdown.selectByVisibleText("Database Testing");  
        //driver.close();
	}
}
