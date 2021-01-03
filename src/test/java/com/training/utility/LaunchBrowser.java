package com.training.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args)  throws Exception {
		
		WebDriver driver = null;
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	//     driver.get("https://www.google.com");
	/*	  driver.manage().window().maximize();
		  driver.quit();
		  
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  driver.get("https://www.google.com");
		  driver.manage().window().maximize();
		  driver.quit();
		 
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
		  driver.get("https://www.google.com");
		  driver.manage().window().maximize();
		  driver.quit();
		 */ 
      driver.get("https://qa-tekarch.firebaseapp.com/");
      driver.manage().window().maximize();
      WebDriverWait wait = new WebDriverWait(driver,10);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
      driver.findElement(By.id("email_field")).clear();
      Thread.sleep(5000);
      driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@placeholder='Password...']")).clear();
     Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("123");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@type='password']")).clear();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("123");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@id='password_field']")).clear();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
      Thread.sleep(2000);
     System.out.println(driver.findElement(By.xpath("//div[@id='login_div']/h3")).getText());
     System.out.println(driver.findElement(By.xpath("//h3")).getText());
   //  System.out.println(driver.findElement(By.xpath("//h3[text() = ' web Login ']")).getText());
   //  System.out.println(driver.findElement(By.xpath("//h3[text() = ' web Login ']")).isDisplayed());
     System.out.println(driver.findElement(By.xpath("//h3")).isDisplayed());
     driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
      Thread.sleep(5000);
      driver.quit();
	}

}
