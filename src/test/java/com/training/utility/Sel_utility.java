package com.training.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sel_utility {
  public static WebDriver driver;
  
  public static void launchBrowser()
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  public static void goToTekarchUrl()
  {
	  driver.get("https://qa-tekarch.firebaseapp.com/");
	  
  }
  public static void waitExplicitly(int iseconds , WebElement ele)
  {
	  WebDriverWait wait = new WebDriverWait(driver, iseconds);
	  wait.until(ExpectedConditions.visibilityOf(ele));
  }
  public static void loginToTekArchPortal()
  {
	  WebElement ele = driver.findElement(By.id("email_field"));
	  waitExplicitly(5,ele);
	  ele.clear();
	  ele.sendKeys("admin123@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password...']")).clear();
	  driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
	  waitExplicitly(5,driver.findElement(By.xpath("//a[contains(text(),'Home')]")));
  }
  public static void printListofWebElements(List<WebElement> li , boolean bPrintSingleLine) throws Exception {
	  for(int count=0;count<li.size();count++){
			 if(bPrintSingleLine)
			 {
				 System.out.print(li.get(count).getText()+ "\t");}
				 else{
					 System.out.println(li.get(count).getText());
				 }
			 if(bPrintSingleLine)
			 {
				 System.out.println();
			 }
	  }
					 
  }
  public static void quitBrowser()
  {
	  driver.quit();
  }
  public static void goToIFrameUrl()
  {
	  driver.get("http://the-internet.herokuapp.com/iframe");
  }
}
  
  
  
  
  
