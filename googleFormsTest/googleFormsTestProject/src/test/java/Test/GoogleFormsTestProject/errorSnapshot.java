package Test.GoogleFormsTestProject;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class errorSnapshot {
	
	public void takescreenshot(WebDriver driver) {
		
		//Create date string to be used in file name
		Date date = new Date();
		String todaysDate = date.toString();
		todaysDate=todaysDate.replaceAll(":","_");
		try {
			File scrFile = (File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(CreateDirectory.fullLogPath+"Failed Step-"+" "+todaysDate+"screenshot.png"));
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
