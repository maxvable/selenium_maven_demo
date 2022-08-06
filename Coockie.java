package com.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Coockie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 try { 
		File file = new File("Cookies.data");	
		 file.delete();		
         file.createNewFile();
         FileWriter fileWrite = new FileWriter(file);							
         BufferedWriter Bwrite = new BufferedWriter(fileWrite);
         Cookie kc= driver.manage().getCookieNamed("NTD");
        
         for(Cookie ck : driver.manage().getCookies())							
         {	
        	 if(ck.getName().equals(kc.getName())) {
        		 System.out.println("Name matches");
        	 }
             Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
             Bwrite.newLine();             
         }			
         Bwrite.close();			
         fileWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
