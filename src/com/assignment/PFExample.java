package com.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFExample {
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	WebElement cancleLogin;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchBox;
	
	@FindBy(xpath="//form//ul/li[1]")
	WebElement suggestion;
	
	public PFExample(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
}
