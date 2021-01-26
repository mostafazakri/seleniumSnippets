package com.mostafa.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://html.com/input-type-file/");
        driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\MrRobot\\Desktop\\testingTypes.JPG");
        driver.quit();
	}
}
