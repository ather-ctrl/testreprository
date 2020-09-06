package DDT_Package;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.DataFormatter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class Newtest2
{
	static AppiumDriver<MobileElement> driver;
	XSSFWorkbook wb;
	static XSSFSheet sheet;
	FileInputStream fis;
	@BeforeTest
	public void g() throws IOException
	{
		File src = new File("home/mohammedathera/TestData.xlsx");
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}
	@Test
	public void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();                                    // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Pixel");                                          
		caps.setCapability("udid", "FA6A40301235"); 										 //Device ID
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "R");
		caps.setCapability("appPackage", "com.swaglabsmobileapp");
		caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		caps.setCapability("noReset", "true");
		Thread.sleep(3000);
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		for(int i =121 ; i<131; i++)
		{
			String data = sheet.getRow(i).getCell(0).getStringCellValue();
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(sheet.getRow(i).getCell(1));
			Thread.sleep(3000);
			MobileElement username=driver.findElementByAccessibilityId("test-Username");                 //5 button
			username.sendKeys(data);
			Thread.sleep(3000);
			MobileElement pwd=driver.findElementByAccessibilityId("test-Password");                 //5 button
			pwd.sendKeys(val);
		}
	}
}