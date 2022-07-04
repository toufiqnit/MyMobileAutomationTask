package Capabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class installAPP {
	
	public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;
		
		File dir =new File("src");
		File app =new File (dir,"nopstationCart_4.40.apk");
		
		DesiredCapabilities dsc =new DesiredCapabilities();
		dsc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
		dsc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dsc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
		dsc.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus S");
		dsc.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		
		
		
		driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dsc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		return driver;
		
		
		
	}

	

	
	
	


}
