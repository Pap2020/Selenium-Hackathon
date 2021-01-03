package com.training.utility;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;

public class ReusableMethods {
	public static WebDriver driver;
//	static ExtentTest test = null;
	
   public static void launchBrowser() {
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://Login.salesforce.com");
   }
public static void enterText(WebElement element, String textToEnter, String elementName)
{
	if(element.isDisplayed()){
	element.sendKeys(textToEnter);
	System.out.println("pass: "+textToEnter+" value is entered in "+elementName+" field");
	}	
	else {
	System.out.println("fail:" +elementName+ "field does not exist please check application");
	}
}		
public static void clickonElement(WebElement element, String elementName){

        element.click();	
	}

public static void waitExplicitly(int iseconds , WebElement ele)
{
	  WebDriverWait wait = new WebDriverWait(driver, iseconds);
	  wait.until(ExpectedConditions.visibilityOf(ele));
}
public static void selectByVisibleText(WebElement ele, String Name) {
	if(ele.isDisplayed()) {
		 Select drop = new Select(ele);
		 drop.selectByVisibleText(Name);
	 System.out.println("Pass: dropdown is selected");
	 }else {
	 System.out.println("Fail: dropdown is not available check your application");
	 }
	 }
static void loginSalesforce(){
    launchBrowser();
    loginOnly();
}  
static void loginOnly(){
    WebElement username = driver.findElement(By.id("username"));
    enterText(username, "pras@myemail.com", "UserName");
    WebElement password = driver.findElement(By.id("password"));
    enterText(password, "chethan@10", "password");
    WebElement loginButton = driver.findElement(By.name("Login"));
    clickonElement(loginButton, "Log In");
}
   }

