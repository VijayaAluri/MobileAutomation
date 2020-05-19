package firststepspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class MyClass {
	
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","G:\\Vijaya Rekha Aluri\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://adactinhotelapp.com/index.php";
        String expectedTitle = "AdactIn.com - Hotel Reservation System";
        String actualTitle = "";

        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }       
        //close Chrome
        driver.close();
    }

}
