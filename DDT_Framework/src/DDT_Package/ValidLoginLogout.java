package DDT_Package;
import org.testng.annotations.Test;
import DDT_Package.LoginPage;
import DDT_Package.SuperClass;
import DDT_Package.Excel;

public class ValidLoginLogout extends SuperClass{
	@Test
	public void verifyLoginWithValidCred ()
	{
		String xl = "TestData.xlsx";
		String Sheet = "Sheet";
		int rowCount = Excel.getRowCount(xl, Sheet);
		for (int i=1;i<=rowCount;i++)
		{
			String UserName=Excel.getCellValue(xl, Sheet, i, 0);
			String Pwd=Excel.getCellValue(xl, Sheet, i, 1);
			LoginPage login = new LoginPage(driver);
			login.Login(UserName,Pwd);
			//Submitting the data by clicking on login button                   
			LoginPage clckLoginBtn = new LoginPage(driver);
			clckLoginBtn.clickLoginBtn();
			System.out.println(UserName);
			System.out.println(Pwd);
		}
	}
}
