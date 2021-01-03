package com.training.utility;
import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SalesForce_TC37 extends ReusableMethods {
public static void main(String[] args)  throws Exception
	{
//	tc01LoginError();
//	tC02LoginToSalesForce();
//	tc03checkRememberMe();
//	tc04ForgotPassword();
//	tc04bForgotPassword();
//	tc05Usermenu();
//	tc06MyProfile();
//	tc07MySettings();
//	tc08DevelopersConsole();
//	tc09Logout();
//	tc10CreateAccount();
//	tc011CreateNewView();
//	tc012EditView();
//	tc013MergeAccounts();
//	tc014accountReport();
//	tc015UserMenu();
//	tc016newOpty();
//	tc017opportunityPipelineReport();
//	tc018StuckOppurtunities();
//	tc019QuaterlySummaryReport();
//	tc20LeadsTab();
//	tc21LeadsSelectView();
//	tc22LeadsDefaultView();
//	tc23TodaysLeadsWork();
//	tc24NewLead();
//	tc25CreateContact();
//	tc26CreateNewView();
//	tC27recentlyCreated();
//	tC28MyContacts();
//	tC29SelectContact();
//	tc30NewViewError();
//	tc31ContactNewViewCancel(); 
//	tc32Contactnewsave();
//	tc33FirstAndLastName();
//	tc34EditedLastName();
//	tc35LaunchandLogin();
	tc36CalendarEvent(); 
	}
		
public static void tc01LoginError() throws Exception  {
	launchBrowser();
	WebElement username = driver.findElement(By.name("username"));
	enterText(username , "palleprasanthi@gmail.com" , "UserName" );
	WebElement password = driver.findElement(By.name("pw"));
	password.clear();
	WebElement Login = driver.findElement(By.name("Login"));
	clickonElement(Login , "LogIn");
	String expectedError = "Please enter your password";
	WebElement errorMsg = driver.findElement(By.xpath("//div[@id='error']"));
	errorMsg.sendKeys(expectedError);
	driver.close();
	Thread.sleep(3000);
	}
		
public static void tC02LoginToSalesForce() throws Exception {
	launchBrowser();
	WebElement username = driver.findElement(By.id("username"));
	enterText(username , "pras@myemail.com" , "UserName" );
	WebElement password = driver.findElement(By.id("password"));
	enterText(password , "chethan@10" ,"Password");
	WebElement Login = driver.findElement(By.name("Login"));
	clickonElement(Login , "LogIn");
	String expectedUrl = "https://tekarch-d-dev-ed.my.salesforce.com//setup/forcecomHomepage.apexp?setupid=ForceCom";
    String actualUrl = driver.getCurrentUrl();
    driver.close();
    Thread.sleep(3000);
}
public static void tc03checkRememberMe() throws Exception {
	launchBrowser();
    WebElement username = driver.findElement(By.id("username"));
    enterText(username, "pras@myemail.com", "UserName");
    WebElement password = driver.findElement(By.id("password"));
    enterText(password, "chethan@10", "password");
    WebElement rememberMe = driver.findElement(By.id("rememberUn"));
    clickonElement(rememberMe, "remember me");
    WebElement loginButton = driver.findElement(By.name("Login"));
    clickonElement(loginButton, "Log In");
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton, "user menu");
    WebElement logOut = driver.findElement(By.linkText("Logout"));
    clickonElement(logOut, "log out");
    driver.close();
    Thread.sleep(3000);
}
public static void tc04ForgotPassword() throws Exception
{
	launchBrowser();
    WebElement forgotPassword = driver.findElement(By.id("forgot_password_link"));
    clickonElement(forgotPassword , "Forgot Password");
    WebElement username = driver.findElement(By.id("un"));
    enterText(username, "pras@myemail.com", "UserName");
    WebElement continueButton = driver.findElement(By.id("continue"));
    clickonElement(continueButton , "Continue");
    String expectedMessage = "We’ve sent you an email with a link to finish resetting your password.";
    driver.close();
    Thread.sleep(3000);
}
public static void tc04bForgotPassword() throws Exception {
	launchBrowser();
    WebElement username = driver.findElement(By.id("username"));
    enterText(username, "123", "UserName");
    WebElement password = driver.findElement(By.id("password"));
    enterText(password, "22131", "password");
    waitExplicitly(5,driver.findElement(By.name("Login")));
    WebElement loginButton = driver.findElement(By.name("Login"));
    clickonElement(loginButton, "Log In");
    String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator";
    waitExplicitly(5,driver.findElement(By.id("error")));
    System.out.println(driver.findElement(By.id("error")).getText());
    driver.close();
    Thread.sleep(3000);
}
public static void tc05Usermenu() throws Exception
{
	launchBrowser();
    WebElement username = driver.findElement(By.id("username"));
    enterText(username, "pras@myemail.com", "UserName");
    WebElement password = driver.findElement(By.id("password"));
    enterText(password, "chethan@10", "password");
    waitExplicitly(5,driver.findElement(By.name("Login")));
    WebElement loginButton = driver.findElement(By.name("Login"));
    clickonElement(loginButton, "Log In");
    waitExplicitly(5,driver.findElement(By.id("userNavLabel")));
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton , "usermenu");
    waitExplicitly(10,driver.findElement(By.id("userNav")));
    WebElement activatedMenuButton = driver.findElement(By.id("userNav"));
    System.out.println(activatedMenuButton.isDisplayed());
    WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    logoutButton.click();
    Thread.sleep(3000);
 }
public static void tc06MyProfile() throws Exception {
	loginSalesforce();
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton, "user menu");
    WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
    clickonElement(myProfile, "My Profile");
    Thread.sleep(8000);
    WebElement editProfile = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]"));
    clickonElement(editProfile , "Edit Profile");
    driver.findElement(By.className("zen-header")).getText();
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
    driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
    WebElement lastName = driver.findElement(By.name("lastName"));
    enterText(lastName, "MuddadaLK", "Last Name");
    WebElement saveAll = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
    clickonElement(saveAll, "save all");
    Thread.sleep(3000);
    driver.close();
 }	
public static void tc07MySettings() throws Exception {
	loginSalesforce();
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton, "user menu");
	WebElement mySettings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
    clickonElement(mySettings, "my settings");
    Thread.sleep(3000);
    WebElement personal = driver.findElement(By.id("PersonalInfo_font"));
    clickonElement(personal, "personal");
    Thread.sleep(3000);
    WebElement loginHistory = driver.findElement(By.id("LoginHistory_font"));
    clickonElement(loginHistory, "Login History");
    Thread.sleep(3000);
    WebElement downloadHistory = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
    clickonElement(downloadHistory, "Download History");
    downloadHistory.isDisplayed();
    Thread.sleep(3000);
    WebElement display_layout = driver.findElement(By.id("DisplayAndLayout_font"));
    clickonElement(display_layout, "Display&Layout");
    Thread.sleep(3000);
    WebElement customizeTab = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
    clickonElement(customizeTab, "Customize Tab");
    Thread.sleep(3000);
    WebElement salesforceChatter = driver.findElement(By.xpath("//select[@id='p4']"));
    selectByVisibleText(salesforceChatter, "Salesforce Chatter");
    Thread.sleep(3000);
    WebElement reports = driver.findElement(By.xpath( "//option[contains(text(),'Reports')]"));
    clickonElement(reports, "Reports");
    Thread.sleep(3000);
    WebElement add = driver.findElement(By.xpath( "//div[contains(text(),'Add')]"));
    clickonElement(add, "Add");
    Thread.sleep(3000);
    WebElement save = driver.findElement(By.xpath( "//tbody/tr[1]/td[2]/input[1]"));
    clickonElement(save, "Save");
    Thread.sleep(3000);
    WebElement email = driver.findElement(By.id("EmailSetup_font"));
    clickonElement(email, "Email");
    Thread.sleep(3000);
    WebElement myEmailSettings = driver.findElement(By.id("EmailSettings_font"));
    clickonElement(myEmailSettings, "My Email Settings");
    Thread.sleep(3000);
    WebElement calendar_remainders = driver.findElement(By.id("CalendarAndReminders_font"));
    clickonElement(calendar_remainders, "calendar & remainder");
    driver.close();
}
public static void tc08DevelopersConsole() throws Exception {
	loginSalesforce();
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton, "user menu");
    Thread.sleep(3000);
    WebElement developerConsole = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
    clickonElement(developerConsole, "Developer Console");
    Thread.sleep(2000);
    driver.quit();
    }
public static void tc09Logout() throws Exception {
	loginSalesforce();
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton, "user menu");
    Thread.sleep(3000);
    WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    logoutButton.click();
    Thread.sleep(3000);
 }
public static void tc10CreateAccount() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement accountsLink = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a[1]"));
    clickonElement(accountsLink, "accounts");
    Thread.sleep(3000);
    WebElement newButton = driver.findElement(By.name("new"));
    clickonElement(newButton , "New");
    Thread.sleep(3000);
    WebElement accountName = driver.findElement(By.id("acc2"));
    String   CreatedAccountName = "Prasanti";
    enterText(accountName, CreatedAccountName, "account name");
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    clickonElement(saveButton, "save");
    Thread.sleep(2000);
    WebElement actualText = driver.findElement(By.xpath("//h2[contains(text(),'Prasanti')]"));
    actualText.getText();
    actualText.isDisplayed();
    driver.close();
}
public static void tc011CreateNewView() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement accountsLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
    clickonElement(accountsLink, "accounts");
    Thread.sleep(3000);
    WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
    clickonElement(createNewView, "Create New View");
    Thread.sleep(5000);
    WebElement viewName = driver.findElement(By.xpath("//label[text()='View Name:']"));
    enterText(viewName, "prasantip", "view name");
 //   viewName.sendKeys("prasantip");
    Thread.sleep(3000);
    WebElement viewUniqueName = driver.findElement(By.xpath("//label[text()='View Unique Name:']"));
    enterText(viewUniqueName,"prasantip","viewUniqueName");
    Thread.sleep(3000);
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    clickonElement(saveButton, "save");
    driver.close();
}
public static void tc012EditView() throws Exception {
	 loginSalesforce();
     WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
     clickonElement(allTabsButton, "+");
     Thread.sleep(3000);
     WebElement accountsLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
     clickonElement(accountsLink, "accounts");
     Thread.sleep(3000);
     WebElement viewNameDropDown = driver.findElement(By.id("fcf"));
     clickonElement(viewNameDropDown, "view");
     Thread.sleep(5000);
     WebElement edit = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[2]/a[1]"));
     clickonElement(edit, "edit");
     Thread.sleep(3000);
     WebElement changeViewName = driver.findElement(By.id("fname"));
     enterText(changeViewName, "AbhiP", "view name");
     Thread.sleep(2000);
     WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
     clickonElement(saveButton, "save");
     Thread.sleep(3000);
     driver.close();
}
public static void tc013MergeAccounts() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement accountsLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
    clickonElement(accountsLink, "accounts");
    Thread.sleep(3000);
    WebElement merge = driver.findElement(By.xpath(" //a[contains(text(),'Merge Accounts')]"));
    clickonElement(merge, "merge");
    Thread.sleep(3000);
    WebElement accountName = driver.findElement(By.id("srch"));
    enterText(accountName, "Prasanti", "account name");
    WebElement findAccounts = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/input[2]"));
    clickonElement(findAccounts, "find accounts");
    Thread.sleep(2000);
    WebElement checkBox = driver.findElement(By.id("cid0"));
    clickonElement(checkBox, "select row 0");
    Thread.sleep(2000);
    WebElement checkBox2 = driver.findElement(By.id("cid1"));
    clickonElement(checkBox2, "select row 1");
    Thread.sleep(2000);
    WebElement next = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[5]/div[1]/input[1]"));
    clickonElement(next, "next");
    Thread.sleep(2000);
    WebElement mergeButton = driver.findElement(By.xpath("//input[@value=' Merge ']"));
    clickonElement(mergeButton, "merge");
    Thread.sleep(5000);
    Alert al = driver.switchTo().alert();
    al.accept();
    Thread.sleep(2000);
     driver.close();
}
public static void tc014accountReport() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement accountsLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
    clickonElement(accountsLink, "accounts");
    Thread.sleep(3000);
    WebElement accountsWithLastActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
    clickonElement(accountsWithLastActivity, "accounts with last activity");
    Thread.sleep(3000);
    WebElement lastActivityDropdown = driver.findElement(By.xpath("//img[@id='ext-gen148']"));
    clickonElement(lastActivityDropdown, "last activity drop down");
    Thread.sleep(3000);
    WebElement createdDate = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
    clickonElement(createdDate, "created date");
    Thread.sleep(3000);
    WebElement from = driver.findElement(By.id("ext-comp-1042"));
    enterText(from, "1/2/2021", "from");
    Thread.sleep(3000);
    WebElement to = driver.findElement(By.id("ext-comp-1045"));
    enterText(to, " ", "to");
    Thread.sleep(3000);
    WebElement saveButton = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
    clickonElement(saveButton, "save button");
    Thread.sleep(3000);
    WebElement reportName = driver.findElement(By.xpath("//label[text()='Report Name']"));
    enterText(reportName, "Prasanti", "report name");
    Thread.sleep(3000);
    WebElement reportUniqueName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
    enterText(reportName, "Prasanti", "report unique name");
    Thread.sleep(3000);
    WebElement saveAndRunReport = driver.findElement(By.xpath("ext-gen316"));
    clickonElement(saveAndRunReport, "save and run");
    driver.close();
}
public static void tc015UserMenu() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement opportunities = driver.findElement(By.xpath("//tbody/tr[9]/td[2]/a[1]"));
    clickonElement(opportunities, "Opportunities button");
    Thread.sleep(3000);
    WebElement opportunitiesDropdown = driver.findElement(By.id("fcf"));
    clickonElement(opportunitiesDropdown, "all opportunity");
    Thread.sleep(5000);
    String expectedText = "all opportunities";
   System.out.println(driver.findElement(By.id("fcf")).getText());
    System.out.println(driver.findElement(By.id("fcf")).isDisplayed());
    driver.close();
}
public static void tc016newOpty() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement opportunities = driver.findElement(By.xpath("//tbody/tr[9]/td[2]/a[1]"));
    clickonElement(opportunities, "Opportunities button");
    Thread.sleep(3000);
    WebElement newopportunity = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    clickonElement(newopportunity, "New");
    Thread.sleep(3000);
    WebElement opportunityName = driver.findElement(By.xpath("//label[text()='Opportunity Name']"));
    enterText(opportunityName, "Prasanti", "Oppurtunity name");
    Thread.sleep(3000);
    WebElement accountName = driver.findElement(By.xpath("//label[contains(text(),'Account Name')]"));
    enterText(accountName, "Prasanti", "Account Name");
    Thread.sleep(3000);
    WebElement leadSource = driver.findElement(By.xpath("//label[contains(text(),'Lead Source')]"));
    selectByVisibleText(leadSource, "Web");
    Thread.sleep(3000);
    WebElement amount = driver.findElement(By.id("amount"));
    enterText(amount, "100", "amount");
    Thread.sleep(3000);
    WebElement closeDate = driver.findElement(By.id("date"));
    enterText(closeDate, "1/1/2021", "close date");
    Thread.sleep(3000);
    WebElement stage = driver.findElement(By.xpath("//label[text()='Stage']"));
    enterText(stage, "Needs Analysis", "Stage");
    WebElement probability = driver.findElement(By.xpath("//label[contains(text(),'Probability (%)')]"));
    enterText(probability, "20", "Probability");
    Thread.sleep(3000);
    WebElement primarycampaign = driver.findElement(By.xpath("//label[contains(text(),'Primary Campaign Source')]"));
    enterText(primarycampaign, "Selenium", "PrimarycampaignSource");
    Thread.sleep(3000);
    WebElement save = driver.findElement(By.xpath(" //tbody/tr[1]/td[1]/div[1]/div[4]/div[2]/form[1]/input[3]"));
    clickonElement(save, "save button");
    String expectedText = "quick create";
    System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[4]/div[2]")).getText());
    System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[4]/div[2]")).isDisplayed());
    driver.close();
 }
public static void tc017opportunityPipelineReport() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement opportunities = driver.findElement(By.xpath("//tbody/tr[9]/td[2]/a[1]"));
    clickonElement(opportunities, "Opportunities button");
    Thread.sleep(3000);
    WebElement opportunityPipeline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
    clickonElement(opportunityPipeline, "Opportunity Pipeline");
    Thread.sleep(3000);
    System.out.println(driver.findElement(By.xpath("//div[@id='status']")).isDisplayed());
        driver.close();
}
public static void tc018StuckOppurtunities() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement opportunities = driver.findElement(By.xpath("//tbody/tr[9]/td[2]/a[1]"));
    clickonElement(opportunities, "Opportunities button");
    Thread.sleep(3000);
    WebElement stuckopportunities = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
    clickonElement(stuckopportunities, " Stuck Opportunities button");
    Thread.sleep(3000);
    String expectedText = "complete";
    System.out.println(driver.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='noTableContainer']/div[1]/form[1]/div[2]/div[1]/div[1]")).isDisplayed());
    driver.close();
}
public static void tc019QuaterlySummaryReport() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement opportunities = driver.findElement(By.xpath("//tbody/tr[9]/td[2]/a[1]"));
    clickonElement(opportunities, "Opportunities button");
    Thread.sleep(3000);
    WebElement quaterlySummary = driver.findElement(By.xpath("//h3[contains(text(),'Quarterly Summary')]"));
    WebElement interval = driver.findElement(By.id("quarter_q"));
    clickonElement(interval, "interval dropdown");
    Thread.sleep(3000);
    WebElement currentFQ = driver.findElement(By.id("quarter_q"));
    clickonElement(currentFQ, "current FQ");
    Thread.sleep(3000);
    WebElement nextFQ = driver.findElement(By.id("quarter_q"));
    clickonElement(nextFQ, "next FQ");
    WebElement include = driver.findElement(By.id("open"));
    clickonElement(include, "include dropdown");
    Thread.sleep(3000);
    String expectedText = "quarterly summary";
    System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/form[1]/table[1]")).isDisplayed());
    driver.close();
    Thread.sleep(3000);
}
public static void tc20LeadsTab() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement leads = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]"));
    clickonElement(leads, "leads");
    Thread.sleep(3000);
    String expectedText = "leads Home";
   System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Home')]")).isDisplayed());
   driver.close();
}
public static void tc21LeadsSelectView() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement leads = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]"));
    clickonElement(leads, "leads");
    Thread.sleep(3000);
    WebElement dropDownList = driver.findElement(By.id("fcf"));
    clickonElement(dropDownList, "view");
    Thread.sleep(3000);
    String expectedText = "all open leads";
    System.out.println(driver.findElement(By.id("fcf")).getText());
    System.out.println(driver.findElement(By.id("fcf")).isDisplayed());
    driver.close();
}
public static void tc22LeadsDefaultView() throws Exception {
	loginSalesforce();
    WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement leads = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]"));
    clickonElement(leads, "leads");
    Thread.sleep(3000);	
    Select dropDownSelect = new Select(driver.findElement(By.id("fcf")));
    String selectedOptionText = "Today's Leads";
    dropDownSelect.selectByVisibleText(selectedOptionText);
    WebElement menuButton = driver.findElement(By.id("userNavLabel"));
    clickonElement(menuButton, "user menu");
    WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    clickonElement(logout, "LOGOUT");
    Thread.sleep(3000);
    loginOnly();
    Thread.sleep(3000);
    loginSalesforce();
    WebElement allTabsButton1= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton1, "+");
    Thread.sleep(3000);
    WebElement leads1 = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]"));
    clickonElement(leads1, "leads");
    Thread.sleep(3000);	
    dropDownSelect = new Select(driver.findElement(By.id("fcf")));
    WebElement option =dropDownSelect.getFirstSelectedOption();
    System.out.println(option.getText());
    System.out.println(option.isDisplayed());
    driver.close();
}
public static void tc23TodaysLeadsWork() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement leads = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]"));
    clickonElement(leads, "leads");
    Thread.sleep(3000);
    WebElement goButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/input[1]"));
    goButton.click();
    Thread.sleep(3000);
    driver.close();
}
public static void tc24NewLead() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement leads = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]"));
    clickonElement(leads, "leads");
    Thread.sleep(3000);
    WebElement newButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    newButton.click();
    Thread.sleep(3000);
    WebElement lastNameField = driver.findElement(By.id("name_lastlea2"));
    lastNameField.sendKeys("ABCD");
    WebElement company = driver.findElement(By.id("lea3"));
    company.sendKeys("ABCD");
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    saveButton.click();
    Thread.sleep(3000);
    driver.close();
 }
public static void tc25CreateContact() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000);
    WebElement newContact= driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    clickonElement(newContact, "New");
    Thread.sleep(3000);
    String lastName = "Palle";
    WebElement lastNameField = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
    lastNameField.sendKeys(lastName);
    WebElement account = driver.findElement(By.xpath("//input[@id='con4']"));
    account.sendKeys("Prasanti");
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    saveButton.click();
    Thread.sleep(3000);
    driver.close();
 }
public static void tc26CreateNewView() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000);
    WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
    newView.click();
    Thread.sleep(3000);
    String viewName = "Palle";
    WebElement viewNameField = driver.findElement(By.xpath("//input[@id='fname']"));
    viewNameField.sendKeys(viewName);
    WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
    viewUniqueName.sendKeys("Palle123");
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    saveButton.click();
    Thread.sleep(4000);
    driver.close();
}
public static void  tC27recentlyCreated() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000); 
    String recentlyCreated = "Recently Created";
    Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='hotlist_mode']")));
    dropDown.selectByVisibleText(recentlyCreated);
    Thread.sleep(3000); 
    driver.close();
}
public static void  tC28MyContacts() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000); 
    String myContancts = "My Contacts";
    Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
    dropDown.selectByVisibleText(myContancts);
    Thread.sleep(5000); 
    driver.close();
}
public static void  tC29SelectContact() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000); 
    WebElement contact = driver.findElement(By.xpath("//tbody/tr[2]/th[1]/a"));
    String contactName = contact.getText();
    contact.click();
    Thread.sleep(3000);
    driver.close();
  }
public static void tc30NewViewError() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000);
    WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
    newView.click();
    Thread.sleep(3000);
    String viewName = "EFGH";
    WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
    viewUniqueName.sendKeys(viewName);
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    saveButton.click();
    Thread.sleep(2000);
    WebElement errorDiv = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[2]\n"));
    System.out.println(errorDiv.getText());
    driver.close();
}
public static void tc31ContactNewViewCancel() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000);
    WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
    newView.click();
    Thread.sleep(3000);
    String viewName = "ABCD";
    WebElement viewNameField = driver.findElement(By.xpath("//input[@id='fname']"));
    viewNameField.sendKeys(viewName);
    WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
    viewUniqueName.sendKeys("EFGH");
    WebElement cancelButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
    cancelButton.click();
    Thread.sleep(4000);
     driver.close();
}
public static void tc32Contactnewsave() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    clickonElement(contacts, "Contacts");
    Thread.sleep(3000);
    WebElement newButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    newButton.click();
    Thread.sleep(3000);
   String lastName = "Indian";
    WebElement lastNameField = driver.findElement(By.xpath("//label[text()='Last Name']"));
    lastNameField.sendKeys(lastName);
   Thread.sleep(3000);
    WebElement account = driver.findElement(By.xpath("//input[@id='con4']"));
    account.sendKeys("Global Media");
    WebElement saveAndNewButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td"));
    saveAndNewButton.click();
    Thread.sleep(3000);
    WebElement contactEdit = driver.findElement(By.xpath("//h2[contains(text(),'Contact Edit')]"));
    System.out.println(contactEdit.getText());
    driver.close();
}
public static void tc33FirstAndLastName() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
    clickonElement(home, "Home");
    Thread.sleep(3000);
    WebElement menu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
    clickonElement(menu, "Menu");
    Thread.sleep(3000);
    WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
    clickonElement(myProfile, "MyProfile");
    Thread.sleep(3000);
    WebElement firstLastName1 = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
    System.out.println(firstLastName1.getText());
    Thread.sleep(3000);
    driver.close();
    }
public static void tc34EditedLastName() throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
    clickonElement(home, "Home");
    Thread.sleep(3000);
    WebElement menu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
    clickonElement(menu, "Menu");
    Thread.sleep(3000);
    WebElement editProfile = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]"));
    editProfile.click();
    Thread.sleep(4000);
    WebElement aboutTab = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
    aboutTab.click();
    WebElement lastName = driver.findElement(By.id("lastName"));
    enterText(lastName, "abcd", "last name");
    WebElement saveAll = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
    saveAll.click();
    WebElement profile = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
  System.out.println(profile.getAttribute("title"));
    driver.close();
}
public static void tc35LaunchandLogin()  throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement customizeTabs = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    customizeTabs.click();
    Thread.sleep(3000);
    Select tabs = new Select(driver.findElement(By.xpath("//select[@id='duel_select_1']")));
    tabs.selectByVisibleText("Subscriptions");
    Thread.sleep(3000);
    WebElement leftArrow = driver.findElement(By.xpath("//a[@id='duel_select_0_left']"));
    leftArrow.click();
    Thread.sleep(3000);
    WebElement save = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    save.click();
    Thread.sleep(3000);
    WebElement menu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
    clickonElement(menu, "Menu");
    Thread.sleep(3000);
    WebElement logOut = driver.findElement(By.linkText("Logout"));
    clickonElement(logOut, "log out");
    loginSalesforce();
	WebElement allTabsButton1= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton1, "+");
    Thread.sleep(3000);
    WebElement customizeTabs1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    customizeTabs1.click();
    Thread.sleep(3000);
    driver.quit();
}
public static void tc36CalendarEvent()  throws Exception {
	loginSalesforce();
	WebElement allTabsButton= driver.findElement(By.xpath("//img[@title='All Tabs']"));
    clickonElement(allTabsButton, "+");
    Thread.sleep(3000);
    WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
    clickonElement(home, "Home");
    Thread.sleep(3000);
    driver.findElement(By.xpath(" ////a[contains(text(),'Sunday January 3, 2021')]")).click();
    WebElement elevenAM = driver.findElement(By.xpath("//a[contains(text(),'11:00 AM')]"));
    elevenAM.click();
    Thread.sleep(2000);
    WebElement subject = driver.findElement(By.xpath("//label[text()='Subject']"));
    subject.click();
    driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div[1]/a[1]/img[1]")).click();
    ArrayList<String> windowsTabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(windowsTabs.get(1));
    driver.close();
    driver.switchTo().window(windowsTabs.get(0));
  //  WebElement Other = driver.findElement(By.xpath("//body/div[2]/ul[1]/li[5]/a[1]"));
 //   Other.click();
 //   driver.switchTo().window(windowsTabs.get(0));
    Thread.sleep(2000);
 //   subject.sendKeys("other");
  Select drop = new Select(driver.findElement(By.xpath("//tbody/tr[3]/td[3]/label[1]")));
//    Select drop = new Select(driver.findElement(By.xpath("//input[@id='EndDateTime_time']")));
    drop.selectByValue("12:00 PM");
    WebElement saveButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
    saveButton.click();
    Thread.sleep(3000);
    driver.close();
}
}


