package com.mostafa.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Navigation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        driver.navigate().to("https://amazon.com/");
        driver.navigate().back();
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        driver.navigate().forward();
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        driver.navigate().back();
        driver.navigate().refresh();
	}
}