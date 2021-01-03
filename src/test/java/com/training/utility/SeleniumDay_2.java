package com.training.utility;

import java.util.List;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDay_2 extends Sel_utility {

	public static void main(String[] args) throws Exception {
		launchBrowser();
		goToTekarchUrl();
		loginToTekArchPortal();
	//	experimentRadioButton();
		experimentDropDown();
	//	experimentWidgetAccordian();
	//	experimentWidgetAutoComplete();
	//	experimentWidgetTable();
		quitBrowser();
	}
		
		public static void experimentRadioButton() throws Exception {
		
    System.out.println(driver.findElement(By.xpath("//input[@value='male']")).isSelected());
    System.out.println(driver.findElement(By.xpath("(//input[@name='gender'])[1]")).isSelected());
	
       driver.findElement(By.xpath("//input[@value='female']")).click();
    
       List<WebElement> li = driver.findElements(By.xpath("//input[@name ='gender']"));
       System.out.println(li.get(0).isSelected());
       System.out.println(li.get(1).isSelected());
          
       Thread.sleep(5000);
		}
		
		public static void experimentDropDown() throws Exception {
		Select se = new Select(driver.findElement(By.id("city")));
		se.selectByVisibleText("NEW DELHI");
		Thread.sleep(3000);
		se.selectByValue("mumbai");
		Thread.sleep(3000);
		se.selectByIndex(3);
		Thread.sleep(3000);
		}
		
	public static void experimentWidgetAccordian() throws Exception {
	waitExplicitly(5,driver.findElement(By.xpath("//button[text()[normalize-space()='Widget']]")));
	driver.findElement(By.xpath("//button[text()[normalize-space()='Widget']]")).click();
//	waitExplicitly(5,driver.findElement(By.xpath("//a[contains(text(),'Accordion')]")));
//	driver.findElement(By.xpath("//a[contains(text(),'Accordion')]")).click();
	waitExplicitly(5,driver.findElement(By.linkText("Accordian")));
	driver.findElement(By.linkText("Accordian")).click();
//	waitExplicitly(5,driver.findElement(By.xpath("//button[text()='Section1')]")));
	waitExplicitly(5,driver.findElement(By.xpath("//button[text()='Section 1']")));
//	driver.findElement(By.xpath("//button[text()='Section1')]")).click();
	driver.findElement(By.xpath("//button[text()='Section 1']")).click();
	
	List<WebElement> li = driver.findElements(By.xpath("//p"));
	System.out.println(li.get(0).getText());
	
	waitExplicitly(5,driver.findElement(By.xpath("//button[text()='Section 2']")));
	driver.findElement(By.xpath("//button[text()='Section 2']")).click();
	driver.findElement(By.xpath("(//div[@class='panel']//p)[2]")).getText();
	waitExplicitly(5,driver.findElement(By.xpath("//button[text()='Section 3']")));
	driver.findElement(By.xpath("//button[text()='Section 3']")).click();
	driver.findElement(By.xpath("(//div[@class='panel']//p)[3]")).getText();
	}
	
	public static void experimentWidgetAutoComplete() throws Exception {
	waitExplicitly(5,driver.findElement(By.xpath("//button[text()[normalize-space()='Widget']]")));
	driver.findElement(By.xpath("//button[text()[normalize-space()='Widget']]")).click();
	waitExplicitly(2,driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]")));
	driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]")).click();
	waitExplicitly(2,driver.findElement(By.id("myInput")));
	driver.findElement(By.id("myInput")).sendKeys("united");
	List<WebElement> li = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
	for(int count=0;count<li.size();count++){
	 if(li.get(count).getText().equalsIgnoreCase("United States of America"))
	 {
		 System.out.println("condition suceed:"+li.get(count).getText());
		 li.get(count).click();
		 break;
	 }
	 else
	 {
		 System.out.println(li.get(count).getText());
	 }
	}
	Thread.sleep(3000);
	}
	
	public static void experimentWidgetTable() throws Exception {
		waitExplicitly(5,driver.findElement(By.xpath("//button[text()[normalize-space()='Widget']]")));
		driver.findElement(By.xpath("//button[text()[normalize-space()='Widget']]")).click();
		waitExplicitly(2,driver.findElement(By.xpath("//a[contains(text(),'Table')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Table')]")).click();
		waitExplicitly(2,driver.findElement(By.xpath("//p[contains(text(),'Table')]")));
		driver.findElement(By.xpath("//p[contains(text(),'Table')]")).click();
		List<WebElement> liHeaders = driver.findElements(By.xpath("//th"));
		printListofWebElements(liHeaders,true);
		List<WebElement> liFirstRow = driver.findElements(By.xpath("//tr[2]/td"));
		printListofWebElements(liFirstRow,true);
		List<WebElement> liSecondRow = driver.findElements(By.xpath("//tr[3]/td"));
		printListofWebElements(liSecondRow,true);
		List<WebElement> liThirdRow = driver.findElements(By.xpath("//tr[4]/td"));
		printListofWebElements(liThirdRow,true);
		
		
		
		
		
		
		
		
		
		
      quitBrowser();
	}
}
