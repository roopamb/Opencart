package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	
	@BeforeClass(groups= {"Regression","Master", "Sanity"})
	@Parameters("browser")
	public void setUp(String br) {
		
	logger = LogManager.getLogger(this.getClass());
	rb= ResourceBundle.getBundle("config");
	
//	WebDriverManager.chromedriver().setup();
		
//	ChromeOptions co = new  ChromeOptions();
//	co.addArguments("--remote-allow-origins=*");
//	co.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});	
		
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	
	
	
	
	if(br.equals("chrome")) {
		driver = new ChromeDriver();
	}
	
	else if(br.equals("edge")) {
		driver = new EdgeDriver();
		
	}
	
	else
	{
		driver = new FirefoxDriver();
		
	}
	
	
	
	driver.manage().deleteAllCookies();
	driver.get(rb.getString("appURL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Regression","Master","Sanity"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randamString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return(generateString);
	}
	
	public String randamNumber() {
		String generateString1 = RandomStringUtils.randomNumeric(10);
		return(generateString1);
	}
	
	public String randamAlpaNumber() {
		String st = RandomStringUtils.randomNumeric(2);
		String num =RandomStringUtils.randomAlphabetic(2);
		return(st+ "@" +num);
		
		
		//if we want to print abcd@1234
		//then we will do concatinate
	}
	
	public  String captureScreen(String tname) throws IOException {
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
//		Date dt = new Date();
//		String timestamp = df.format(dt);
	
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 
		 TakesScreenshot takesScreenshot = (TakesScreenshot) driver ;
		 File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		 String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png" ;
				 
				 try {
					 FileUtils.copyFile(source, new File(destination));
				 }
				 catch(Exception e) {
					 
					 e.getMessage();
				 }
		 
				 return destination ;
	 }
	
	
	
	
	
	
	
}

