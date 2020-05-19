package firststepspackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class ClickMethod {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","G:\\Vijaya Rekha Aluri\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://adactinhotelapp.com/index.php";
        String actualTitle = "";
        
        driver.get(baseUrl);
        
        WebElement myelement = driver.findElement(By.xpath("//a[@href='ForgotPassword.php']"));
        myelement.click();
        
        actualTitle = driver.getTitle();
        
       String expectedResult = "AdactIn.com - Forgot Password";        
       
       if (actualTitle.contentEquals(expectedResult))
       {
           System.out.println("expectedResult:"+expectedResult +'\n');
       } 
       else 
       {
           System.out.println("actualTitle:"+actualTitle);
       }                 
        driver.close();
        System.exit(0);       	
	}
}
