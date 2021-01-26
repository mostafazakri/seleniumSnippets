package com.mostafa.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
		driver.manage().window().maximize();
			
		String text = driver.findElement(By.xpath("//div[@id='et-boc']//div[@class='et_pb_text_inner']/h3")).getText();
		System.out.println(text);
	}

}
