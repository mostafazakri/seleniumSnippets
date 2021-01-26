package com.mostafa.test1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();     
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        if(text.equals("Please enter a valid user name")) {
            System.out.println("Correct Alert Message");
        }else {
            System.out.println("Incorrect Alert Message");
        }
        alert.accept();
        driver.quit();
	}
}
