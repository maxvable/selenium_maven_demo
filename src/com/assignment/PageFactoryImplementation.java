package com.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PageFactoryImplementation {
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	WebElement cancleLogin;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchBox;
	
	@FindBy(xpath="//form//ul/li[1]")
	WebElement suggestion;

	@Test
	public void pomDemo() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://flipkart.com");
		PFExample example=new PFExample(driver);
		example.cancleLogin.click();
		example.searchBox.sendKeys("Samsung");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		example.suggestion.click();
		
	}
}
