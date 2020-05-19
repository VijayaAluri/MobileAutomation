package firststepspackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;




public class AdactinHotelLogin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","G:\\Vijaya Rekha Aluri\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
		System.out.print("Test1: Hotel Web app should be launched Successfully"+'\n');
		
        String baseUrl = "http://adactinhotelapp.com/index.php";      
        driver.get(baseUrl);
        
	    WebElement UserName = driver.findElement(By.id("username"));
        
        if(UserName.isEnabled()) 
        {
        System.out.print("Test1 Result: Hotel Web app Launched Successfully"+'\n');        
        }
        
        WebElement Password = driver.findElement(By.id("password"));
        
        WebElement LoginButton = driver.findElement(By.id("login"));
        
        System.out.print("Test2 : Should be Able to enter Username,Password and click on Login"+'\n');  
        UserName.sendKeys("bdravrmay15");
        Password.sendKeys("2");
        LoginButton.click();
        System.out.print("Test2 Result: Able to enter Username,Password and click on Login"+'\n');  
        
        System.out.print("Test3 : Should be Able to redirect to Search Hotel Page"+'\n');  
        
        String CurrentURL = driver.getCurrentUrl();
        
        System.out.print("CurrentURL: "+CurrentURL+'\n');
                             
        String ActualTitle = driver.getTitle();
        
        String ExpectedTitle =   "AdactIn.com - Search Hotel";
        
        if(ActualTitle.contains(ExpectedTitle))
        {
        	System.out.println("Test3 Passed: Page redirected to Search Hotel Page"+'\n');
        	
        }
        else
        {
        	System.out.println("Test3 Fail- ActualTitle: "+ActualTitle+'\n');
        }
        
           
        System.out.println("Test4 : Welcome to AdactIn Group of Hotels should be displayed in the Top"+'\n');
        
        if(driver.findElement(  By.xpath("//td[@class= 'welcome_menu' and contains(text(), 'Welcome to AdactIn Group of Hotels')]")).isDisplayed());
        {
        	System.out.println("Test4 Passed: Welcome to AdactIn Group of Hotels displayed in the Top"+'\n');
        	
        }
        
        driver.navigate().to(baseUrl);
        
        System.out.println("Test5 : Should redirect to New User Registration Page"+'\n');
        
        WebElement Link_NewUserReg = driver.findElement(By.linkText("New User Register Here"));
        Link_NewUserReg.click();
        
        String ANewUserRegTitle = driver.getTitle();
        
       String ENewUserRegTitle = "AdactIn.com - New User Registration";        
       
       if (ANewUserRegTitle.contentEquals(ENewUserRegTitle))
       {
    	   System.out.println("Test5 Passed: Redirected to New User Registration Page - " +ENewUserRegTitle+'\n');
       } 
       else 
       {
           System.out.println("Test5 Fail: " +ANewUserRegTitle+'\n');
       }
           
       
       driver.navigate().back();
       
       System.out.println("Test6 : Should redirect to Forgotpassword Page"+'\n');
       WebElement Link_ForgotPassword = driver.findElement(By.xpath("//a[@href='ForgotPassword.php']"));
       Link_ForgotPassword.click();
       
       String AForgotPasswordTitle = driver.getTitle();
       
      String EForgotPasswordTitle = "AdactIn.com - Forgot Password";        
      
      if (AForgotPasswordTitle.contentEquals(EForgotPasswordTitle))
      {
   	   System.out.println("Test6 Passed: Redirected to Forgotpassword Page - " +EForgotPasswordTitle+'\n');
      } 
      else 
      {
          System.out.println("Test6 Fail: " +AForgotPasswordTitle+'\n');
      } 
         
      System.out.println("Test7 : Should see Link to Go to LoginPage"+'\n');
      WebElement Link_GoToLoginPage = driver.findElement(By.linkText("Go back to Login page"));
      Link_GoToLoginPage.click();
      
      String ALoginPageTitle = driver.getTitle();
      
     String ELoginPageTitle = "AdactIn.com - Hotel Reservation System";        
     
     if (ALoginPageTitle.contentEquals(ELoginPageTitle))
     {
  	   System.out.println("Test7 Passed: Redirected to LoginPage - " +ELoginPageTitle+'\n');
     } 
     else 
     {
         System.out.println("Test7 Fail: " +ALoginPageTitle+'\n');
     }
     
     System.out.println("Test8 : Reset button should clear all the elements"+'\n');
     Link_ForgotPassword.click();
     
    if (AForgotPasswordTitle.contentEquals(EForgotPasswordTitle))
    {
    	WebElement eMailIDRecovery = driver.findElement(By.id("emailadd_recovery"));
    	eMailIDRecovery.sendKeys("vraluri999@gmail.com");
    	driver.findElement(By.id("Reset")).click();
    	String textInsideeMailIDRecovery = eMailIDRecovery.getAttribute("value");
    	if(textInsideeMailIDRecovery.isEmpty())
    	{
    	   System.out.println("Test8 Passed: Reset button is working and Input field is empty" +'\n');
    	}
    	else
    	{
    	System.out.println("Test8 Error: Reset button is not working and Input field is not empty - " +textInsideeMailIDRecovery+'\n');
    	}
    } 
    else 
    {
        System.out.println("Test8 Fail: " +AForgotPasswordTitle+'\n');
    } 
    
    
	
         
        driver.close();
        System.exit(0);
                       
	}
	
	
}

//Test1

/**@Test(priority=0)

public void test_Login_Page_Appear_Correct(){

    //Create Login Page object

objLogin = new AdactinHotelWebLogin(driver);

//Verify login page title

String loginPageTitle = objLogin.getLoginTitle();

System.out.print("test_Login_Page_Appear_Correct:loginPageTitle: " + loginPageTitle+ '\n');     

Assert.assertTrue(loginPageTitle.contains("AdactIn.com - Hotel Reservation System"));
**/

//Test 2
/** @Test(priority=1)

 public void test_Home_Page_Appear_Correct(){

     //Create Login Page object

 objLogin = new AdactinHotelWebLogin(driver);

 //Verify login page title

 String loginPageTitle = objLogin.getLoginTitle();
 System.out.print("test_Home_Page_Appear_Correct:loginPageTitle: " + loginPageTitle+ '\n');     

 Assert.assertTrue(loginPageTitle.contains("AdactIn.com - Hotel Reservation System"));

 //login to application

 objLogin.loginToAdactinHotelApp("bdravrmay15", "2");

 // go the next page

 objHomePage = new AdactinHotelWebHome(driver);

 //Verify home page

 Assert.assertTrue(objHomePage.getHomePageUserName().contains("Welcome to AdactIn Group of Hotels"));
 
 
}

**/
 
 
