package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import java.util.Set;
import java.util.logging.Logger;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void browseropen(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void Demosite() throws IOException, InterruptedException{
		
		
	//1)	Reading from the excel
		TestUtil.Readingexcelfile("Demo");
		String value = TestUtil.Readingexcelfile("Demo");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(value,Keys.ENTER);
		
    //2) Sorting using dropdown
		//Actions act =  new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("(//*[contains(text(),'Sort by')])[2]"))).click().perform();		
//		driver.findElement(By.xpath("(//*[contains(text(),'Price: Low to High')])[2]")).click();
    //3)Taking Screenshot
		WebElement phonename = driver.findElement(By.linkText("New Apple iPhone 12 Pro (128GB) - Pacific Blue"));
		String phone = phonename.getText();
		System.out.println(phone);
		phonename.click();
		TestUtil.takeScreenshotAtEndOfTest();
		
	//4)Swtiching to the new tab
		String currentHandle= driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String actual: handles) {
		if(!actual.equalsIgnoreCase(currentHandle)) {
		//Switch to the opened tab
		driver.switchTo().window(actual);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		
	//5) Reading the webelement
		WebElement webele = driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input"));
	    assertEquals(webele.isDisplayed(), true);
	}
		}
		
	}
	
	//Using Testng Priority
	
	@Test(priority=2)
     public void Demosite1() throws InterruptedException, IOException{
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 8t",Keys.ENTER);
		WebElement phonename = driver.findElement(By.linkText("OnePlus 8T 5G (Aquamarine Green, 8GB RAM, 128GB Storage)"));
		String phone = phonename.getText();
		System.out.println(phone);
		phonename.click();
		TestUtil.takeScreenshotAtEndOfTest();
		String currentHandle= driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String actual: handles) {
		if(!actual.equalsIgnoreCase(currentHandle)) {
		driver.switchTo().window(actual);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		WebElement webele = driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input"));
	    assertEquals(webele.isDisplayed(), true);
	    
	}
		}
		}
	
	
	
	@AfterMethod
	public void browserclose(){
		driver.quit();
	
	}
	
	
	

}
