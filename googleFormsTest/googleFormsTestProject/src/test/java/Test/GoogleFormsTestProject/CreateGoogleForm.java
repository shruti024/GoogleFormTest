package Test.GoogleFormsTestProject;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateGoogleForm 
{
    public void createGoogleForm(WebDriver driver)
    {
    	
    	try {
    	driver.findElement(By.xpath("//div[@title='Blank']/../../..//img")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//textarea[contains(text(),'Untitled form')]")).sendKeys("Test Form");
    	driver.findElement(By.xpath("//textarea[@aria-label ='Form description']")).sendKeys("Test Form");
    	driver.findElement(By.xpath("//textarea[@aria-label ='Question title']")).click();
    	driver.findElement(By.xpath("//textarea[@aria-label ='Question title']")).sendKeys("Short Answer");
    	List<WebElement> typeofQuestion = driver.findElements(By.xpath("//div[@role = 'option']"));
    	typeofQuestion.get(0).click();
    	driver.findElement(By.xpath("(//div[@guidedhelpid='addQuestionGH'])[1]")).click();
    	System.out.println("Successful");
    } catch(Exception e){
		errorSnapshot screenshot = new errorSnapshot();
		screenshot.takescreenshot(driver);
		System.out.println("Error in "+CreateGoogleForm.class+" "+e);
		driver.quit();
	}
   }
}
