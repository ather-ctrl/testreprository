package DDT_Package;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginPage extends SuperClass{
	public static AppiumDriver<MobileElement> driver;
	//Initializing the Objects
	public LoginPage(AppiumDriver<MobileElement> driver)
	{
		LoginPage.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//Locating Login button
	@AndroidFindBy(accessibility = "test-Username") private MobileElement usernameTxtFld;
	@AndroidFindBy(accessibility = "test-Password") private MobileElement passwordTxtFld;
	@AndroidFindBy(accessibility = "test-LOGIN") private MobileElement loginBtn;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") private MobileElement errTxt ;

	public void Login (String UN,String PWD)
	{
		usernameTxtFld.sendKeys(UN);
		passwordTxtFld.sendKeys(PWD);
	}

	//Clicking on Login button

	public void clickLoginBtn()
	{
		loginBtn.click();
	}
}
