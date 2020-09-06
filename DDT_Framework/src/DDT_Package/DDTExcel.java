package DDT_Package;                                                                //Enter package name
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DDTExcel
{
	public static AppiumDriver<MobileElement> driver;

	@Test(dataProvider="testdata")
	public void DemoProject(String username, String password) throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();                                // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Pixel");                                          
		caps.setCapability("udid", "FA6A40301235"); 										 //Device ID
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "R");
		caps.setCapability("appPackage", "com.swaglabsmobileapp");
		caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		Thread.sleep(2000);
		MobileElement user=driver.findElementByAccessibilityId("test-Username");                  
		user.sendKeys(username);
		MobileElement pass=driver.findElementByAccessibilityId("test-Password");           
		pass.sendKeys(password);
		Thread.sleep(2000);
	}

	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{

		ReadExcelFile config = new ReadExcelFile("TestData.xlsx");  

		int rows = config.getRowCount(0);

		Object[][] credentials = new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			credentials[i][0] = config.getData(0, i, 0);
			credentials[i][1] = config.getData(0, i, 1);
			
		}

		return credentials;
	}

	@AfterMethod
	void ProgramTermination()
	{
		driver.quit();
	}
}