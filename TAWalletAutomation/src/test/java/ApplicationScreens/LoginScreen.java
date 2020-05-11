package ApplicationScreens;

import testcases.BaseClass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginScreen extends  BaseClass {
	
	public LoginScreen() throws IOException
	{
		
		 System.out.println("Application Initialized");
		 		  
	}
	
	/** this method is to find the element Allow button by using ID and to do the click action. * */
	
	public void AllowContactsAccessButton() 
	{
		
		try {
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
	        System.out.println("AllowContactsAccessButton clicked");
		}
		catch(Exception exp)
		{
			System.out.println("Unable to click AllowContactsAccessButton");
		}
	}
	
	/** Explicit wait is used here to wait till the enter mobile number text box is visible. Once it is visible,
	 * this method find the Mobile number & Password text boxes by id and enter the values Username ,password by using Sendkeys properties * */
	
	  public void EnterDetails(String username, String password)
	  {
		 		  
		  try 
		  {
			  WebDriverWait wait = new WebDriverWait(driver,10);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ta.wallet.tawallet:id/mobile")));
			  driver.findElementById("com.ta.wallet.tawallet:id/mobile").sendKeys(username); 
			  driver.findElementById("com.ta.wallet.tawallet:id/pass").sendKeys(password); 
			  
		  }
		  catch(Exception exp) 
		  {
	           System.out.println("Unable to enter user details");
	      } 
	  }
	  /** this method is to find the element Login by using ID and to do the click action. 
	   * The driver will wait for 5 seconds till the app login and load the Home page * */
	  public void Login() 
	  { 
		  try 
		  { 
			  driver.findElementById("com.ta.wallet.tawallet:id/button2").click();
	          System.out.println("LoginButton clicked");
	          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  } 
		  catch(Exception exp) 
		  {
	           System.out.println("Unable to click LoginButton");
	      } 
	  }
	 
	  /** this method is to verify if the Username label in Home page is displayed to understand that the application is logged in successfully * */

	public void VerifyWhetherLoggedintoScreen() {
		try
		  {
	  if(driver.findElementById("com.ta.wallet.tawallet:id/topLNameBalRP").isDisplayed())
	  	{
		  System.out.println("User logged in successfully"); 
		  }
	  else {
		  System.out.println("User login failed"); }
	  
		  }
		  catch(Exception exp)
		  {
			  System.out.println("Unable to Loginto the Application");
		  }
		
	}
}
