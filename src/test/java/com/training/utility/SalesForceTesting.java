package com.training.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceTesting {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.get("https://tekarch-d-dev-ed.my.salesforce.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 System.out.println(driver.findElement(By.id("logo")).isDisplayed());
		 Thread.sleep(3000);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		 driver.findElement(By.id("username")).click();
		 driver.findElement(By.id("username")).sendKeys("pras@myemail.com");
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
		 driver.findElement(By.id("password")).click();
		 driver.findElement(By.id("password")).sendKeys("chethan@10");
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Login"))));
		 driver.findElement(By.id("Login")).click();
		 Thread.sleep(3000);
		 driver.quit();
		 
		 
		 
		
	}

}
