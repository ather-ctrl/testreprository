package DDT_Package;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SuperClass {

	public static AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void preCondition() {
		try {

			DesiredCapabilities caps = new DesiredCapabilities();                                    // Created object of DesiredCapabilities class.
			caps.setCapability("deviceName", "Pixel");                                          
			caps.setCapability("udid", "FA6A40301235"); 										 //Device ID
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "R");
			caps.setCapability("appPackage", "com.swaglabsmobileapp");
			caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
			driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 

	}
	@AfterClass
	public void postCondition() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}