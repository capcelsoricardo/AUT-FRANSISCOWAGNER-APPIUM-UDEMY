package appiumudemy.config;
	
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

	public class SetUp {

	  public static AndroidDriver<MobileElement> driver;
	 	  
	  public static AndroidDriver<MobileElement> createDriver() {
		  
		File pathApk = new File("src/test/resources/CTAppium-1-1.apk");
		  
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    //desiredCapabilities.setCapability("testobject_api_key", "FDB6CDEFE1524EBDB966756A41212223");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, pathApk.getAbsolutePath());
	    desiredCapabilities.setCapability("appPackage", "com.ctappium" );
	    desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
	    //desiredCapabilities.setCapability("noReset", false);
	    
	    
		try {			
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
			//driver = new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {		
			e.printStackTrace();
		}
	    
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    	    
	    
	    return driver;
	  }
	  
	  public static AndroidDriver<MobileElement> getDriver() {
		  if(driver == null)
			  createDriver();		  
		  return driver;
	  }	  	 	  	
	  
	  public static void killDriver() {		  		  
		  if (driver != null) {
			  driver.quit();
			  driver = null;
		  }		  		  
	  }
}
