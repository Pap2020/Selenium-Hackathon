package com.training.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;


public class SeleniumDay_3 extends Sel_utility{
//	private static final String JavascriptExecutor = null;
	public static void main(String[] args) throws Exception {
		launchBrowser();
	//	goToIFrameUrl();
		goToTekarchUrl();
		loginToTekArchPortal();
	//	experimentAlert();
	//	experimentTabsandWindows();
	//	experimentTabs();
	//	experimentIFrame();
	//	experimentCalculator();
	//	experimentIntractions();
	//	experimentDoubleClick(); 
	//	experimentToolTip();
		experimentFileUpload();
		quitBrowser();
	}
public static void experimentAlert() throws Exception {
	driver.findElement(By.xpath("//div[@class='dropdown']//button")).click();
	waitExplicitly(5, driver.findElement(By.xpath("//a[@href='./alert.html']")));
	driver.findElement(By.xpath("//a[@href='./alert.html']")).click();
/*	waitExplicitly(5, driver.findElement(By.xpath("//button[text()='Window Alert']")));
	driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
	Alert al = driver.switchTo().alert();
	System.out.println(al.getText());
	al.accept();
	Thread.sleep(5000);
	waitExplicitly(5, driver.findElement(By.xpath("//button[contains(text(),'Window Alert')][2]")));
	//driver.findElement(By.xpath("//div[@id='overflowTest']]")).click();
	WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')][2]"));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",ele);
	*/
	waitExplicitly(5, driver.findElement(By.xpath("//button[text()='Promt Alert']")));
	driver.findElement(By.xpath("//button[text()='Promt Alert']")).click();
	Alert al = driver.switchTo().alert();
	System.out.println(al.getText());
	al.sendKeys("Harry Potter");
	Thread.sleep(3000);
//	al.accept();
	al.dismiss();
	Thread.sleep(5000);
}



  public static void experimentTabsandWindows() throws Exception {
	driver.findElement(By.xpath("//div[@class='dropdown']//button")).click();
	waitExplicitly(5, driver.findElement(By.linkText("Windows")));
	driver.findElement(By.linkText("Windows")).click();
	waitExplicitly(5,driver.findElement(By.xpath("//button[@type='button']")));
	driver.findElement(By.xpath("//button[@type='button']")).click();
	Thread.sleep(5000);
	ArrayList<String> windowsTabs = new ArrayList<String>(driver.getWindowHandles());
	System.out.println(windowsTabs.size());
	driver.switchTo().window(windowsTabs.get(1));
	driver.get("https://www.amazon.com");
	driver.close();
//	System.out.println(windowsTabs.size());
	driver.switchTo().window(windowsTabs.get(2));
	driver.get("https://www.tekarch.com");
	driver.close();
//	driver.switchTo().window(windowsTabs.get(3));
//	driver.get("https://www.amazon.com");
//	driver.close();
	driver.switchTo().window(windowsTabs.get(0));
	driver.findElement(By.xpath("//button[@type='button']")).click();
	Thread.sleep(5000);
	waitExplicitly(5,driver.findElement(By.xpath("//button[contains(text(),'Window')]")));
	driver.findElement(By.xpath("//button[contains(text(),'Window')]")).click();
	Thread.sleep(5000);
	ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	System.out.println(windows.size());
	driver.switchTo().window(windows.get(1));
	driver.get("https://www.tekarch.com");
	driver.close();
	driver.switchTo().window(windows.get(0));
	driver.findElement(By.xpath("//button[@type='button'])[2]")).click();
	Thread.sleep(5000);
}
  public static void experimentTabs() throws Exception {
	  driver.findElement(By.xpath("//div[@class='dropdown']//button")).click();
	  waitExplicitly(5, driver.findElement(By.xpath("//a[@href='./tabview.html']")));
	  driver.findElement(By.xpath("//a[@href='./tabview.html']")).click();
	  waitExplicitly(5,driver.findElement(By.xpath("//div[@class='tab']//button[1]")));
	  driver.findElement(By.xpath("//div[@class='tab']//button[1]")).click();
	//  driver.findElement(By.xpath("//h3[contains(text()='London')]"));
	  List<WebElement> li = driver.findElements(By.xpath("//p"));
	  System.out.println(li.get(0).getText());
	  Thread.sleep(5000);
/*	  waitExplicitly(5,driver.findElement(By.xpath("//div[@class='tab']//button[2]")));
	  driver.findElement(By.xpath("//div[@class='tab']//button[2]")).click();
	  List<WebElement> li = driver.findElements(By.xpath("//p"));
	  System.out.println(li.get(1).getText());
	  Thread.sleep(5000);*/
	  waitExplicitly(5,driver.findElement(By.xpath("//div[@class='tab']//button[3]")));
	  driver.findElement(By.xpath("//div[@class='tab']//button[3]")).click();
	  List<WebElement> li1 = driver.findElements(By.xpath("//p"));
	  System.out.println(li1.get(2).getText());
	  Thread.sleep(5000);
  }
  public static void experimentIFrame() throws Exception{
	  Thread.sleep(5000);
	//  driver.findElement(By.xpath("//body[@id='tinymce']"));
  System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
  driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr"))); 
  System.out.println(driver.findElement(By.xpath("//body[@id='tinymce']")));
	  Thread.sleep(5000);
  }
  public static void experimentCalculator() throws Exception {
  driver.findElement(By.xpath("//a[contains(text(),'Calculator')]")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//input[@class='button digits']")));
  driver.findElement(By.xpath("//input[@class='button digits']")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//input[@class='button mathButtons']")));
  driver.findElement(By.xpath("//input[@class='button mathButtons']")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//input[@value='3']")));
  driver.findElement(By.xpath("//input[@value='3']")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//input[@value='=']")));
  driver.findElement(By.xpath("//input[@value='=']")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//input[@id='display']")));
  driver.findElement(By.xpath("//input[@id='display']")).click();
  Thread.sleep(5000);
  }
  public static void experimentIntractions() throws Exception {
  driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
  Actions action = new Actions(driver);
  action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"))).perform();
  waitExplicitly(5,driver.findElement(By.xpath("//a[contains(text(),'Mouse Hover')]")));
  driver.findElement(By.xpath("//a[contains(text(),'Mouse Hover')]")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//button[contains(text(),'mousehover')]")));
  driver.findElement(By.xpath("//button[contains(text(),'mousehover')]"));
  Actions action1 = new Actions(driver);
  action1.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'mousehover')]"))).perform();
  waitExplicitly(5,driver.findElement(By.linkText("Alert")));
  driver.findElement(By.linkText("Alert")).click();
   Alert al = driver.switchTo().alert();
  System.out.println(al.getText());
  al.accept();
  Thread.sleep(5000);
  }
  public static void experimentDoubleClick() throws Exception {
  driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
  Actions action = new Actions(driver);
  action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"))).perform();
  waitExplicitly(5,driver.findElement(By.xpath("//a[contains(text(),'Double Click')]")));  
  driver.findElement(By.xpath("//a[contains(text(),'Double Click')]")).click();
  waitExplicitly(5, driver.findElement(By.tagName("button")));    
  driver.findElement(By.tagName("button")).click();
  waitExplicitly(5,driver.findElement(By.xpath("//button[@type='button']")));
  driver.findElement(By.xpath("//button[@type='button']")).click();
  Actions action1 = new Actions(driver);
  action1.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"))).perform();
  action1.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"))).perform();
  action1.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"))).perform();
  Thread.sleep(5000);
  }
  public static void experimentToolTip() throws Exception {
	  driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
	  Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"))).perform();
   driver.findElement(By.linkText ("Tool Tip")).click();
   waitExplicitly(5,driver.findElement(By.xpath("//div[@class='tooltipr']")));
   driver.findElement(By.xpath("//div[@class='tooltipr']"));
   Actions act = new Actions(driver);
   act.moveToElement(driver.findElement(By.xpath("//div[@class='tooltipr']"))).perform();
   waitExplicitly(5,driver.findElement(By.xpath("//div[@class='tooltipl']")));
   driver.findElement(By.xpath("//div[@class='tooltipl']"));	
   Actions act1 = new Actions(driver);
   act1.moveToElement( driver.findElement(By.xpath("//div[@class='tooltipl']"))).perform();
   Thread.sleep(3000);
  }
  public static void experimentFileUpload() throws Exception {
  driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
  waitExplicitly(5,driver.findElement(By.id("//input[@id='logo']")));
  driver.findElement(By.id("//input[@id='logo']")).sendKeys("This pc:\\pictures\\saved pictures\\om.jpg");
  driver.findElement(By.xpath("//div[@class='imagearea']//img[1]"));
  Thread.sleep(5000);
	  
  }
}
