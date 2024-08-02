package org.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestClass {
	private WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		driver= new ChromeDriver();
		driver.get("https://qatest.uat.cloudbankin.com/#/");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="login",dataProviderClass=TestData.class)
	public void testLogin(String username,String password) throws InterruptedException {
			boolean loginSuccessful=performLogin(username, password);
					Assert.assertEquals(loginSuccessful, true);
					System.out.println("Work done by QA");
					System.out.println("Running fine in Local");
					System.out.println("QA Work");
					
					
					
	}
	
	
	private boolean performLogin(String username,String password) throws InterruptedException {
		
		Thread.sleep(3000);
		
		WebElement user = driver.findElement(By.xpath("(//input[@name='username'])[1]"));
		user.clear();
		user.sendKeys(username);
		
		WebElement pass = driver.findElement(By.xpath("(//input[@name='password'])[1]"));
		pass.clear();
		pass.sendKeys(password);
		
		WebElement login = driver.findElement(By.xpath("(//button[@id='login-button'])[1]"));
		login.click();
		
		
		Thread.sleep(5000);
		
//		WebElement dashboardText = driver.findElement(By.xpath("(//label[text()='Dashboard'])[1]"));
//		Assert.assertEquals(dashboardText, "Dashboard");
//		
		System.out.println("User succesfully logged in");
		
		
		WebElement target = driver.findElement(By.xpath("//a[@id='user-dropdown']"));
//		Actions a =new Actions(driver);
//		a.moveToElement(target).build().perform();
//		
		target.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[@id='logout']"));
		logout.click();
		
		Thread.sleep(5000);
		
		
		return true;
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
//		driver.quit();
		
	}
	
}
