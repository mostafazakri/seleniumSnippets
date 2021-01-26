package com.mostafa.test1;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

 

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

 

        driver.get("https://www.facebook.com/");
        //driver.get("https://makemysushi.com/Recipes/404");
        
        //1-Get the list of all the links and images:
        List<WebElement>linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));
        System.out.println("Size of total links and images ----->" + linksList.size());
        List<WebElement>activeLinks = new ArrayList<WebElement>();
        
        //2-iterate linksList
        
        for(int i=0; i < linksList.size(); i++) {
            System.out.println(linksList.get(i).getAttribute("href"));
            if((linksList.get(i).getAttribute("href")) != null && ( !linksList.get(i).getAttribute("href").contains("javascript"))) {
                activeLinks.add(linksList.get(i));
            }
        }
        
        //3-Get the size of active links list
        System.out.println("Size of active links and images ----->" + activeLinks.size());
        
        /*
         * 200--OK
         * 404--Not Found
         * 500--intertnal error
         * 400--Bad request
         */
        
        //4-Check the href url, with httpconnection api
        
        for(int j =0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "--->" + response);
        }
            

 

    }

 

}
