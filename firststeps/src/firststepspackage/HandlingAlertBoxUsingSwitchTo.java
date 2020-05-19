package firststepspackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class HandlingAlertBoxUsingSwitchTo {
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","G:\\Vijaya Rekha Aluri\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 String alertMessage = "";

	        driver.get("http://jsbin.com/usidix/1");
	        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
	        alertMessage = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();
	       
	        System.out.println(alertMessage);
	        driver.quit();
}
}