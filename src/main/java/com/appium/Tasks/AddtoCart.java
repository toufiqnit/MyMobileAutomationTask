package com.appium.Tasks;


import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import Capabilities.Utils;
import Capabilities.installAPP;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class AddtoCart {

	private AndroidDriver<AndroidElement> driver = null;
	TouchAction touch;
	

	@Test (priority=1)
	public void SelectingLumia() throws MalformedURLException, InterruptedException {
		driver =installAPP.getDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath(Utils.Read_Accept)).click();
		driver.findElement(By.xpath(Utils.Category)).click();
		driver.findElement(By.xpath(Utils.Electronics)).click();
		
		

		//scroll to Lumia and Select it
		
		Thread.sleep(1000);		
		scrollto();
		Thread.sleep(1000);	
		scrollto();
		Thread.sleep(1000);
		scrollto();
		Thread.sleep(1000);
		scrollto();
		Thread.sleep(1500);
		scrollto();
		

		driver.findElement(By.xpath(Utils.Lumia)).click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
		
		@Test (priority=2)
		public void AddingLumiatoCart() {
			System.out.println("entered on Lumia page");
			
			
			 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Quantity\").instance(0))"));

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			
			driver.findElement(By.xpath(Utils.PlusIcon)).click(); // quantity increasing to two

			
			driver.findElement(By.xpath(Utils.AddtoCart)).click();
			
			
		}
		
		
		@Test(priority =3)
		public void GotoCheckout() throws MalformedURLException {
			driver.findElement(By.xpath(Utils.GotoCart)).click();
			driver.findElement(By.xpath(Utils.CheckOutButton)).click();
			driver.findElement(By.xpath(Utils.AsGuest)).click();
			
		}
		
		@Test(priority=4)
		public void ProvidingAddress() {
			driver.findElement(By.xpath(Utils.Firstname)).sendKeys("Mike");
			driver.findElement(By.xpath(Utils.Lastname)).sendKeys("Black");
			driver.findElement(By.xpath(Utils.Email)).sendKeys("mb@bs.com");
			driver.findElement(By.xpath(Utils.CountryDropDown)).click();
			driver.findElement(By.xpath(Utils.Country)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Street address 2\").instance(0))"));
			
			
			driver.findElement(By.xpath(Utils.StateDropDown)).click();
			driver.findElement(By.xpath(Utils.State)).click();
			driver.findElement(By.xpath(Utils.Company)).sendKeys("MyCompany");
			driver.findElement(By.xpath(Utils.City)).sendKeys("NoCity");
			driver.findElement(By.xpath(Utils.Street)).sendKeys("R:404");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Fax\").instance(0))"));
			
			driver.findElement(By.xpath(Utils.Zip)).sendKeys("500");
			driver.findElement(By.xpath(Utils.Continue)).click();
		}
		
		@Test(priority=5)
		public void ShiipingAndPayment() throws InterruptedException {
			driver.findElement(By.xpath(Utils.NextDay)).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1,5)"));
			driver.findElement(By.xpath(Utils.Continue)).click();
			Thread.sleep(1000);
			
		}
		@Test(priority=6)
		public void Payment () {
			
			driver.findElement(By.xpath(Utils.Bkash)).click(); // need to select bkash to start scroll on this view
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5,5)"));
			driver.findElement(By.xpath(Utils.CheckorMoney)).click();
			driver.findElement(By.xpath(Utils.Continue)).click();
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			driver.findElement(By.xpath(Utils.NEXTButton)).click();
			
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5,5)"));

			
			driver.findElement(By.id(Utils.ConfirmButton)).click();
			
			
		}
		@Test(priority=7)	
		public void CheckConfirmation() {
			AndroidElement success = driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message"));
			success.isDisplayed();
			System.out.println(success.getText());
			
			driver.stopRecordingScreen();
		}
			
			
			
			
			

	
		private  void scrollto() {
			Dimension size = driver.manage().window().getSize();
			int startx= size.getWidth()/2;
			int endx= size.getWidth()/2;
			int starty =(int) (size.getHeight()*0.73);
			int endy = (int) (size.getHeight()*0.10);
			
			new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
			
			
			
		}

	}

	
	  

