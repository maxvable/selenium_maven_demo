package com.assignment;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class Base {

	public static File scrFile; 
	public static WebDriver driver;
	public static InputStream input;
	public static Properties prop;

	@BeforeSuite
	public void invokeDriver() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			input=new FileInputStream("locators.properties");
			prop = new Properties();
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));

	}

	@Test(priority=0)
	public void cancleLogin() {
		driver.findElement(By.xpath(prop.getProperty("cancle_login"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=1)
	public void search() throws IOException {
		File file = new File("search.txt");
		BufferedReader br= new BufferedReader(new FileReader(file));
		String st;
		String search = null;
		while ((st = br.readLine()) != null) {
			search=st;
		}   
		driver.findElement(By.xpath(prop.getProperty("search_box"))).sendKeys(search);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(prop.getProperty("suggestion_click"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=2)
	public void filter() {
		String locator=prop.getProperty("price_dropdown");
		WebElement price=driver.findElement(By.xpath(locator));
		Select select=new Select(price);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=(String) prop.get("price_filter");
		select.selectByValue(value);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(prop.getProperty("ram_filter"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(prop.getProperty("processor"))).click();
		driver.findElement(By.xpath(prop.getProperty("snapdragon"))).click();
	}

	@Test(priority=3)
	public void results() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List <WebElement>name=driver.findElements(By.xpath(prop.getProperty("name")));
		List <WebElement>price=driver.findElements(By.xpath(prop.getProperty("price")));
		File file = new File("result.csv");
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] header = {"Phone Name", "Current Price"};
			writer.writeNext(header);
			for(int i = 0;i<name.size();i++) {
				String[] data1 = {name.get(i).getText(),price.get(i).getText().substring(1)};
				writer.writeNext(data1);
			}
			writer.close();
		}
		catch (IOException e) {

			e.printStackTrace();
		}

	}
	@Test(priority=4)
	public void takeScreenShot() {
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

		try {
			ImageIO.write(screenshot.getImage(),"PNG",new File("screenshot"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@AfterSuite
	public void closeAll() {
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}


}
