package firststepspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;

public class IdentifyElements {

	public static void  main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","G:\\Vijaya Rekha Aluri\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://adactinhotelapp.com/index.php";
        String tagname = "";
        
        driver.get(baseUrl);
        tagname = driver.findElement(By.id("login")).getTagName();
        // getTagName() method to extract the tag name of that particular element whose id is "login"
       
        System.out.println(tagname);
        driver.close();
        System.exit(0);
        
	}
}
