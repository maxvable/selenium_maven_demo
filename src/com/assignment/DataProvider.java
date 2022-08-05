package com.assignment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProvider {

	
	@org.testng.annotations.DataProvider(name="search")
	public Object[][] provider(){
	return new Object[][] {{"http://google.com","Selenium"},
		};
	
	}
	
	@Test(dataProvider="search")
	public void dataProviderDemo(String para1,String para2) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(para1);
		driver.findElement(By.name("q")).sendKeys(para2);
	}
	
}
