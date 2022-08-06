package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Headless {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new HtmlUnitDriver();
		 
         driver.get("http://www.google.com");					
         WebElement element = driver.findElement(By.name("q"));	
         element.sendKeys("Selenium");	
         element.submit();			
         System.out.println("Page title is: " + driver.getTitle());	
	}

}
