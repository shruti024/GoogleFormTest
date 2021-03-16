package Test.GoogleFormsTestProject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateDirectory {

	public static String strDirectory;
	public static String fullLogPath;
	public static String reportDate;
	
	public static void main(String args[]) {
		CreateDirectory createDirectory = new CreateDirectory();
		createDirectory.createDirectoryForScreenshot();
	}
	
	public void createDirectoryForScreenshot() {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date today = Calendar.getInstance().getTime();
		reportDate = df.format(today);
		
		try {
			
			strDirectory = "TestFolder - "+reportDate;
			boolean success = (new File(strDirectory)).mkdir();
			if(success) 
			{
				fullLogPath = "C:\\" + strDirectory + "\\";
				System.out.println("TestFolder created: "+fullLogPath);
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
}
