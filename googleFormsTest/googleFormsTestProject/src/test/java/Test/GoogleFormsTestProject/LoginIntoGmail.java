package Test.GoogleFormsTestProject;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginIntoGmail extends MainTest
{
	public void LoginThroughGmail(WebDriver driver) {
		
		try {
		
		//Entering Username and password
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("itw.testauotmation@gmail.com");
		driver.findElement(By.xpath("(//button[@type ='button'])[3]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("fnw00t##");
		driver.findElement(By.xpath("(//button[@type ='button'])[3]")).click();
		Thread.sleep(2000);
		WebElement enterLastPassword = driver.findElement(By.xpath("//input[@type='password']"));
		if (enterLastPassword.isDisplayed()) {
			enterLastPassword.sendKeys("fnw00t##");
			driver.findElement(By.xpath("(//button[@type ='button'])[3]")).click();
			System.out.println("Entered last password");
		}
    	
		//Calling createGoogleForm Class
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CreateGoogleForm createGoogleForm = new CreateGoogleForm();
		createGoogleForm.createGoogleForm(driver);
    	}catch(Exception e) {
			errorSnapshot screenshot = new errorSnapshot();
			screenshot.takescreenshot(driver);
			System.out.println("Error in "+LoginIntoGmail.class+" "+e);
			driver.quit();
	}
		
	}
    }
    
