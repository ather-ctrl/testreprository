package KeywordDriven;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.net.MalformedURLException;
import java.net.URL;


public class Actions 
{
	public static AppiumDriver<MobileElement> driver;
	
	public static void launchApp() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();                                    // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Pixel");                                          
		caps.setCapability("udid", "FA6A40301235"); 										 //Device ID
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "R");
		caps.setCapability("appPackage", "com.swaglabsmobileapp");
		caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		Thread.sleep(4000);
		System.out.println(" keyword driven Login successful");
	}

	@Test
	public static void input_Username()
	{
		MobileElement user=driver.findElementByAccessibilityId("test-Username");                   //5 button
		user.sendKeys("standard_user");
	}

	public static void input_Password()
	{
		MobileElement pass=driver.findElementByAccessibilityId("test-Password");            //5 button
		pass.sendKeys("secret_sauce");
	}
	
	public static void closeApp()
	{
		driver.quit();
	}
}
	/*@Test
 public static void verify_login()
 {
 String pageTitle = driver.getTitle();
 Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours:");
 }*/

	
