package Test.GoogleFormsTestProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTest {
	
	private static WebDriver driver;
	public static void main(String args[]) {
		MainTest mainTest = new MainTest();
		mainTest.launchBrowser(driver);
	}
	
	public void launchBrowser(WebDriver driver) {
		
		try {
	    String gmailUrl = "https://docs.google.com/forms";
	      
        System.out.println("Launching Google Chrome browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(gmailUrl);
        
        //Fetching the title of Page and verifying it
        String testTitle = "Google Forms: Sign-in";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
		LoginIntoGmail loginIntoGmail  = new LoginIntoGmail();
		loginIntoGmail.LoginThroughGmail(driver);
		
		} catch(AssertionError e){
			errorSnapshot screenshot = new errorSnapshot();
			screenshot.takescreenshot(driver);
			System.out.println("Error in "+MainTest.class+" "+e);
			driver.quit();
		}
	}
	
}

