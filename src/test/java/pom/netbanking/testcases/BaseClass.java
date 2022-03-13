package pom.netbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netbanking.utilities.Readconfig;

import org.testng.annotations.AfterClass;


public class BaseClass {
	
	Readconfig readconfig= new Readconfig();
	
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getPassword();
	public String chromepath=readconfig.getchromepath();
	public String firefoxpath=readconfig.getfireffoxpath();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver =new ChromeDriver();
		}
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfireffoxpath());
			driver =new FirefoxDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
			
					
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	

}
