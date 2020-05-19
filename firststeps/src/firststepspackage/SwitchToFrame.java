package firststepspackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class SwitchToFrame {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","G:\\Vijaya Rekha Aluri\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("classFrame");
        // You can find the frame name during inspect code
        driver.findElement(By.linkText("Deprecated")).click();
        driver.close();
}
}
