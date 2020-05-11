package testcases;

import org.testng.annotations.Test;
import ApplicationScreens.LoginScreen;
import Utilities.ExcelUtil;
import testcases.BaseClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;

/** This class is to get the Test Data by calling ExcelUtil class
 * Run the Test Steps to execute the Test case
 * @author Vijaya Rekha
 */

public class LoginTest extends  BaseClass {
	static LoginScreen lp;
	//Main Directory of the project
		public static final String currentDir = System.getProperty("user.dir");
		public static final String excelpath = currentDir + "/excel/TestData.xlsx";
		public static final String excelSheetname = "Credentials";
		
		/** The "test1" method is calling Dataprovider "test1data" to get the Credentials of a user		 * 
		 * @param username
		 * @param password
		 * This one is also calling Login Screen methods to execute the Test Steps
		 */
		
	@Test(dataProvider="test1data")
	public void test1(String username, String password) {
		System.out.println("Username: " + username + '\n' + "Password: " + password);
		
		try {
			  
			  lp=new LoginScreen(); 
			  System.out.println("LoginScreen started"+'\n');
			  
			  /** Calling AllowContactsAccessButton method from Loginscreen class to click on AllowCeess to contacts button displayed	while launching the App * */
			  
			  lp.AllowContactsAccessButton();	
			  
			  /** Calling EnterDetails method from Loginscreen class to  enter the Username and Password* */
			  
			  lp.EnterDetails(username,password); 
			  
			  /** Calling Login method from Loginscreen class to click on Login button * */
			  
			  lp.Login();
			  
			  /** Calling VerifyWhetherLoggedintoScreen method from Loginscreen class to check whether the user is logged into the aoolication successfully * */
			  
			  lp.VerifyWhetherLoggedintoScreen();
			  
			  System.out.println("LoginScreen Completed");
			  
			  /** The driver is waiting for 10 seconds after logging into the application before executing AfterRun	 * */
			  
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  } 
		 catch(Exception exp) {
			  System.out.println("TestLogin Cause is.. "+exp.getCause());
			  System.out.println("TestLogin Message is.. "+exp.getMessage());
			  exp.printStackTrace(); 
			  
			  }	
	}
	
	
	
	@DataProvider(name = "test1data")
	public  Object[][] getData()
	{
		Object data[][] = testdata(excelpath, excelSheetname);
		return data;
	}
	/** The "testdata" method is passing the parameters excelpath and Sheetname to ExcelUtil class to get the below values		 
	 * No.Of Rown in the excel sheet
	 * No.Of columns in the Sheet
	 * This method is iterating the values and reading the celldata from getcelldata method and returing the data to Test1 method
	 */
	public  Object[][] testdata(String excelpath, String sheetName)
	{
	 ExcelUtil excel = new ExcelUtil(excelpath, sheetName);
	 
	 int rowCount = excel.getRowcount();
	 int colcount = excel.getColcount();
	 Object data[][] = new Object[rowCount-1][colcount];
	 
	 for(int i=1; i< rowCount; i++)
	 {
		 for(int j=0; j< colcount; j++) {
			String celldata = excel.getCellData(i, j);
			data[i-1][j] = celldata;
			 
		 }
		 System.out.println();
	 }
	 return data;
	 
	}
}