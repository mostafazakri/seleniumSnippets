package com.mostafa.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteCookies {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "drivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://google.com/");
	}
}
